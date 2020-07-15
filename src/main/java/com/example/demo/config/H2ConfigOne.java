package com.example.demo.config;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;


/**
 * @Description
 * @ClassName H2ConfigOne
 * @Author Administrator
 * @date 2020.07.14 14:02
 */
@MapperScan(basePackages = "com.example.demo.dao",sqlSessionFactoryRef = "h2SqlSessionFactoryOne")
@Configuration
public class H2ConfigOne {
    @Bean(name = "h2DataSourceOne")
    @ConfigurationProperties(prefix = "spring.datasource.one")
    @Primary
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "h2TransactionManagerOne")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(this.dataSource());
    }

    @Bean(name = "h2SqlSessionFactoryOne")
    @Primary
    public SqlSessionFactory sqlSessionFactory(@Qualifier("h2DataSourceOne") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sessionFactory.getObject();
    }

    @Bean(name = "h2TemplateOne")
    @Primary
    public JdbcTemplate h2Template(@Qualifier("h2DataSourceOne") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}