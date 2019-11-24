package com.jooq.shop.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource dataSource() {
        //DataSource druidDataSource = DataSourceBuilder.create().build();
        DataSource dataSource = DruidDataSourceBuilder.create().build();
        //DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
    }

}
