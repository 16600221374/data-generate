package generator.atomikos;

/**
 * @ClassName: MybatisConfig
 * @Author: liuzuncai
 * @Description:
 * @Date: 2021/2/24 10:06
 * @Version: 1.0
 */

import java.util.Properties;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.atomikos.jdbc.AtomikosDataSourceBean;

@Configuration
public class MybatisConfig {
    @Value("${spring.datasource.account.url}")
    private String accountDbUrl;

    @Value("${spring.datasource.account.username}")
    private String accountUsername;

    @Value("${spring.datasource.account.password}")
    private String accountPassword;

    @Value("${spring.datasource.storage.url}")
    private String storageDbUrl;

    @Value("${spring.datasource.storage.username}")
    private String storageUsername;

    @Value("${spring.datasource.storage.password}")
    private String storagePassword;

    final static Logger logger = LoggerFactory.getLogger(MybatisConfig.class);

    /**
     * 配置druid显示监控统计信息 开启Druid的监控平台 http://localhost:8080/druid
     *
     * @return servlet registration bean
     */
//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        logger.info("Init Druid Servlet Configuration ");
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),
//                "/druid/*");
//        // IP白名单，不设默认都可以
//        // servletRegistrationBean.addInitParameter("allow",
//        // "192.168.2.25,127.0.0.1");
//        // IP黑名单(共同存在时，deny优先于allow)
//        servletRegistrationBean.addInitParameter("deny", "192.168.190.131");
//        // 控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", "root");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        // 是否能够重置数据 禁用HTML页面上的“Reset All”功能
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }

    @Bean(name = "accountDataSource")
    @Primary
    public DataSource accountDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("accountDataSource");
        atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        Properties properties = new Properties();
        properties.put("URL", accountDbUrl);
        properties.put("user", accountUsername);
        properties.put("password", accountPassword);
        atomikosDataSourceBean.setXaProperties(properties);
        return atomikosDataSourceBean;
    }

    @Bean(name = "storageDataSource")
    public DataSource storageDataSource() {
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setUniqueResourceName("storageDataSource");
        atomikosDataSourceBean.setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        Properties properties = new Properties();
        properties.put("URL", storageDbUrl);
        properties.put("user", storageUsername);
        properties.put("password", storagePassword);
        atomikosDataSourceBean.setXaProperties(properties);
        return atomikosDataSourceBean;
    }
}
