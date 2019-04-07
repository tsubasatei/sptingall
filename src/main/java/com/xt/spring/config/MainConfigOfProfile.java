package com.xt.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xt.spring.bean.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;

/**
 * @author xt
 * @create 2019/4/6 9:50
 * @Desc
 */
//@Profile("test")
@PropertySource({"classpath:/dbConfig.properties"})
@Configuration
public class MainConfigOfProfile implements EmbeddedValueResolverAware {


    private String driverClass;
    @Value("${db.user}")
    private String user;

    @Bean
//    @Profile("test")
    public Yellow yellow() {
        return new Yellow();
    }

    @Profile("test")
    @Bean("test")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql:///test");
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }

//    @Profile("default")
    @Profile("dev")
    @Bean("dev")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql:///learning");
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prod")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql:///spring");
        dataSource.setDriverClass(driverClass);
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        String resolveStringValue = stringValueResolver.resolveStringValue("${db.driver}");
        this.driverClass = resolveStringValue;
    }
}
