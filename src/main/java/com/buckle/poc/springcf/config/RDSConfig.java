package com.buckle.poc.springcf.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class RDSConfig {

    @Primary
    @Bean(name = "rdsDataSource")
    @ConfigurationProperties("spring.datasource.rds")
    public DataSource rdsDataSource() {
        return DataSourceBuilder.create()
                .build();
    }

    @Bean(name = "rdsJdbcTemplate")
    public JdbcTemplate rdsJdbcTemplate(@Qualifier("rdsDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
