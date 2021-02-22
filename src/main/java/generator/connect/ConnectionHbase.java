package generator.connect;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

/**
 * @ClassName: ConnectionHbase
 * @Author: liuzuncai
 * @Description: 连接hbase使用jdbc的方式
 * @Date: 2021/1/28 10:37
 * @Version: 1.0
 */
@Slf4j
public class ConnectionHbase {

    private static final String PHOENIX_URL_PART_SEPERATOR = ":";

    private static final String HBASE_REGIONSERVER_KERBEROS_PRINCIPAL = "hbase.regionserver.kerberos.principal";

    private static final String HBASE_MASTER_KERBEROS_PRINCIPAL = "hbase.master.kerberos.principal";

    private static final String HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT = "hbase.zookeeper.property.clientPort";

    private static final String ZOOKEEPER_ZNODE_PARENT = "zookeeper.znode.parent";

    private static final String HBASE_ZOOKEEPER_QUORUM = "hbase.zookeeper.quorum";

    private static final String HBASE_SECURITY_AUTHORIZATION = "hbase.security.authorization";

    private static final String HADOOP_SECURITY_AUTHORIZATION = "hadoop.security.authorization";

    private static final String HADOOP_SECURITY_AUTHENTICATION = "hadoop.security.authentication";

    private static final String HBASE_SECURITY_AUTHENTICATION = "hbase.security.authentication";

    private static final String PHOENIX_SCHEMA_MAP_SYSTEM_TABLES_TO_NAMESPACE = "phoenix.schema.mapSystemTablesToNamespace";

    private static final String PHOENIX_SCHEMA_IS_NAMESPACE_MAPPING_ENABLED = "phoenix.schema.isNamespaceMappingEnabled";

    private static final String[] HBASE_PROP_KEYS = new String[] { PHOENIX_SCHEMA_IS_NAMESPACE_MAPPING_ENABLED,
            PHOENIX_SCHEMA_MAP_SYSTEM_TABLES_TO_NAMESPACE, HBASE_SECURITY_AUTHENTICATION,
            HADOOP_SECURITY_AUTHENTICATION, HADOOP_SECURITY_AUTHORIZATION, HBASE_SECURITY_AUTHORIZATION,
            HBASE_ZOOKEEPER_QUORUM, ZOOKEEPER_ZNODE_PARENT, HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT,
            HBASE_MASTER_KERBEROS_PRINCIPAL, HBASE_REGIONSERVER_KERBEROS_PRINCIPAL };

    public static final String krb5Conf = "D:\\etc\\117krb\\krb5.conf";
    public static final String hbaseSiteXml = "D:\\etc\\117krb\\hbase-site.xml";
    public static final String coreSiteXml = "D:\\etc\\117krb\\core-site.xml";
    public static final String principal = "ossuser/wmc-node-1@HADOOP.COM";
    public static final String userKeytab = "D:\\etc\\117krb\\ossuser.keytab";
    private static String daasJaas = "D:\\etc\\117krb\\daas_jaas.conf";



    public static final String CREATE_SCHEMA = "create schema IF NOT EXISTS LZCTEST";

    public static final String CREATE_DDL = "create table IF NOT EXISTS LZCTEST.STUDENT( "
            + "stu_id INTEGER NOT NULL,"
            + "stu_name VARCHAR(32),"
            + "stu_age INTEGER,"
            + "stu_address VARCHAR(128),"
            + "class_id INTEGER,"
            + "create_time TIMESTAMP,"
            + "CONSTRAINT stu_pk PRIMARY KEY (stu_id))";

    public static final String INSERT_SQL = "upsert into LZCTEST.STUDENT(stu_id,stu_name,stu_age,stu_address,class_id, create_time) "
            + "values(1,'胡道权',28,'北京市王府井1号',2,2021-01-28:17:00:00)";

    public static final String SELECT_SQL = "select * from LZCTEST.STUDENT";

    public static void main(String[] args) {
        Connection connection = getConn();
        createNameSpace(connection,INSERT_SQL);
    }

    static Connection getConn() {

        // 初始化配置文件
        System.setProperty("java.security.auth.login.config", daasJaas);
        System.setProperty("java.security.krb5.conf", krb5Conf);

        Properties props = new Properties();
        final Configuration conf = HBaseConfiguration.create();
        try {
            FileInputStream core = new FileInputStream(hbaseSiteXml);
            FileInputStream hbase = new FileInputStream(coreSiteXml);
            conf.addResource(core);
            conf.addResource(hbase);

            for (String propKey : HBASE_PROP_KEYS) {
                if (null != conf.get(propKey)) {
                    props.setProperty(propKey, conf.get(propKey));
                }
            }
        } catch (IOException e) {
            log.info("Failed to load hbase configuration files", e);
        }
        try {
            Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        } catch (Exception e) {
            log.info("Can not find jdbc driver");
        }

        StringBuilder builder = new StringBuilder("jdbc:phoenix:");
        builder.append(conf.get(HBASE_ZOOKEEPER_QUORUM)).append(PHOENIX_URL_PART_SEPERATOR)
                .append(conf.get(HBASE_ZOOKEEPER_PROPERTY_CLIENT_PORT))
                .append(PHOENIX_URL_PART_SEPERATOR)
                .append(conf.get(ZOOKEEPER_ZNODE_PARENT));
        if (StringUtils.isNotEmpty(principal)) {
            builder.append(PHOENIX_URL_PART_SEPERATOR).append(principal).append(PHOENIX_URL_PART_SEPERATOR)
                    .append(userKeytab);
        }
        final String phoenixJdbcUrl = builder.toString();

        log.info("Start to connect server...");

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(phoenixJdbcUrl, props);
//			if("kerberos".equals(conf.get("hbase.security.authentication"))) {
//				UserGroupInformation ugi = UserGroupInformation.loginUserFromKeytabAndReturnUGI(principal, userKeytab);
//				conn = ugi.doAs(new PrivilegedAction<Connection>() {
//
//					@Override
//					public Connection run() {
//						try {
//							return DriverManager.getConnection(phoenixJdbcUrl, props);
//						} catch (Exception e) {
//				            log.info("Can not find jdbc driver");
//				        }
//						return null;
//					}
//				});
//			} else {
//				conn = DriverManager.getConnection(phoenixJdbcUrl, props);
//			}

        } catch(Exception e) {
            log.info("Failed to connect phoenix", e);
        }
        return conn;
    }

    static void createNameSpace(Connection connection,String sql) {
        try{
            connection.createStatement().execute(sql);
        }catch (Exception e) {
            log.error(e.getMessage());
        }

    }
    static List<Map<String,Object>> getData(Connection connection,String sql) {
        List<Map<String,Object>> result = new ArrayList<>();
        ResultSet resultSet = null;
        try{
            resultSet = connection.prepareStatement(sql).executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();

            int colCount = metaData.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 0; i < colCount; i++) {
                    String colName = metaData.getColumnName(i + 1);
                    Object colValue = resultSet.getObject(i + 1);
                    row.put(colName, colValue);
                }
                result.add(row);
            }
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }
}
