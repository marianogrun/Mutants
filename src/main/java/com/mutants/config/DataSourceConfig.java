package com.mutants.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://aa1xkthl8h2qtk2.cs7v8pkhvbmj.sa-east-1.rds.amazonaws.com:3306/mutantes"); //URL de base / puerto / nombre de la base
        dataSourceBuilder.username("phpmyadmin");
        dataSourceBuilder.password("phpmyadmin");
        return dataSourceBuilder.build();
    }

}
