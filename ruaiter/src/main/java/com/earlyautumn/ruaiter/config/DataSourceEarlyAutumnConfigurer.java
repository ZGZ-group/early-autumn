package com.earlyautumn.ruaiter.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
@MapperScan(
        basePackages = {DataSourceEarlyAutumnConfigurer.BASE_PACKAGE},
        sqlSessionFactoryRef = DataSourceEarlyAutumnConfigurer.SQL_SESSION_FACTORY)
@EnableTransactionManagement
public class DataSourceEarlyAutumnConfigurer {

    static final String BASE_PACKAGE = "com.earlyautumn.ruaiter.user.dao.earlyautumn";
    static final String SQL_SESSION_FACTORY = "sqlSessionFactoryEarlyAutumn";

    private static final Logger logger = LoggerFactory.getLogger(DataSourceEarlyAutumnConfigurer.class);
    private static final String DATA_SOURCE_PROPERTY = "dataSourcePropertyEarlyAutumn";
    private static final String MYBATIS_CONFIG = "classpath:mybatis/mybatis-config.xml";
    private static final String MYBATIS_MAPPERS = "classpath:com/earlyautumn/ruaiter/user/dao/earlyautumn/mappers/*.xml";
    private static final String TX_MANAGER = "txManagerEarlyAutumn";

    @Primary
    @Bean(name = DATA_SOURCE_PROPERTY)
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource(
            @Value("${database.test.driver}") String driver,
            @Value("${database.test.username}") String username,
            @Value("${database.test.password}") String password,
            @Value("${database.test.url}") String url
    ) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    @Bean(name = SQL_SESSION_FACTORY)
    public SqlSessionFactory sqlSessionFactoryTest(@Qualifier(DATA_SOURCE_PROPERTY) DataSource dataSource) {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(MYBATIS_CONFIG));
            sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MYBATIS_MAPPERS));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            logger.error("failed to create data sql session", e);
            throw new RuntimeException();
        }

    }

    @Bean(name = TX_MANAGER)
    public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier(DATA_SOURCE_PROPERTY) DataSource dataSource) {
        DataSourceTransactionManager txManager = new DataSourceTransactionManager();
        txManager.setDataSource(dataSource);
        return txManager;
    }

    /**
     * 配置druid监控
     * @return
     */
    @Bean
    public ServletRegistrationBean statServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> param =new HashMap<>();
        param.put("loginUsername","admin");
        param.put("loginPassword","123456");
        param.put("allow","");
        servletRegistrationBean.setInitParameters(param);
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> param =new HashMap<>();
        param.put("exclusions","*.js,*.css,/druid/*");
        filterRegistrationBean.setInitParameters(param);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
//    @Bean
//    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory); // 使用上面配置的Factory
//        return template;
//    }

}

