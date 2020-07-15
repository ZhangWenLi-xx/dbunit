package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;


/**
 * @Description
 * @ClassName H2ConfigTwo
 * @Author Administrator
 * @date 2020.07.14 14:02
 */
@Configuration
@MapperScan(basePackages = "com.example.demo.dao",sqlSessionFactoryRef = "h2SqlSessionFactoryTwo")
public class H2ConfigTwo {
    @Bean(name = "h2DataSourceTwo")
    @ConfigurationProperties(prefix = "spring.datasource.two")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "h2TransactionManagerTwo")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @Bean(name = "h2SqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("h2DataSourceTwo") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }

    @Bean(name = "h2TemplateTwo")
    public JdbcTemplate h2Template(@Qualifier("h2DataSourceTwo") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}