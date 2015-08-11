package com.lynas.config;

import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

/**
 * Created by sazzad on 8/11/2015.
 */
@Configuration
public class Appconfig {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setSuffix(".jsp");
        return irvr;
    }

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        dataSource.addDataSourceProperty("serverName", "localhost");
        dataSource.addDataSourceProperty("databaseName", "studentdb");
        dataSource.addDataSourceProperty("user", "root");
        dataSource.addDataSourceProperty("password", "s123456");

        return dataSource;
    }



    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

    @Bean
    public AnnotationSessionFactoryBean sessionFactoryBean() {
        AnnotationSessionFactoryBean asfb = new AnnotationSessionFactoryBean();
        asfb.setDataSource(dataSource());
        asfb.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
        asfb.setHibernateProperties(hibernateProperties());
        return asfb;
    }

    public SessionFactory sessionFactory() {
        return sessionFactoryBean().getObject();
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sessionFactory());
        return manager;
    }



}
