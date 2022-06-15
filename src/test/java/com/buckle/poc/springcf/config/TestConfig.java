package com.buckle.poc.springcf.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Profile("test")
public class TestConfig {
    @Bean(name = "h2DataSource")
//    @ConfigurationProperties("spring.datasource.h2")
    public DataSource h2DataSource() {
        var builder = new EmbeddedDatabaseBuilder();
        var db = builder
                .setType(EmbeddedDatabaseType.H2)// HSQL or DERBY
                .addScript("h2-db/schema.sql")
                .addScript("h2-db/test-data.sql")
                .build();
        return db;
    }

    @Bean(name = "h2JdbcTemplate")
    public JdbcTemplate h2JdbcTemplate(@Qualifier("h2DataSource") DataSource ds) {
        var jdbc = new JdbcTemplate(ds);
        return jdbc;
    }
}
