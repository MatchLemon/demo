package com.yb.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan({"com.hrabbit.admin.modual.system.mapper"})
public class DataSourceConfig {

//    /**
//     * Druid配置
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidProperties druidProperties() {
//        return new DruidProperties();
//    }
//
//    /**
//     * 单数据源连接池配置
//     */
//    @Bean
//    public DruidDataSource dataSource(DruidProperties druidProperties) {
//        DruidDataSource dataSource = new DruidDataSource();
//        druidProperties.config(dataSource);
//        return dataSource;
//    }

    /**
     * mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("mysql");
        return paginationInterceptor;
    }
}
