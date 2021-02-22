package generator;

import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO
 *
 * @Author: HuDaoquan
 * @Email: hudaoquan@enn.cn
 * @Date: 2020.10.20 16:39
 * @Version 1.0
 */
public class ConnectImpala {

    private static String daasJaas = "/etc/141krb/daas_jass.conf";

    private static String krb5 = "/etc/141krb/krb5.conf";

    private static String url = "jdbc:impala://cluster-node-2/originald;AuthMech=1;KrbRealm=HADOOP.COM;KrbHostFQDN=${public.impala.url-KrbHostFQDN};KrbServiceName=impala";

    public static final String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";

    public static void test(String sql) {

        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        String CONNECTION_URL = url;
        System.setProperty("java.security.auth.login.config", daasJaas);
        System.setProperty("java.security.krb5.conf", krb5);
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(CONNECTION_URL);
            ps = con.prepareStatement(sql);

            ps.executeBatch();
            while (rs.next()) {
                System.out.println("result:" + rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally  {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String sql = "select * from zzjgztb_ryantest1";
        test(sql);
    }
}
