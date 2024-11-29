package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("jdbc:postgresql://localhost:5432/libreria")
    private String url;
    @Value("postgres")
    private String user;
    @Value("1234")
    private String password;

    @Value("org.postgresql.Driver")
    private String driver;

    @Bean
    public DataSource businessDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driver);
        return dataSource;
    }
}
