package ru.neoflex.banking.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DaoConfig {
    @Bean
    @Qualifier("queryDataSource")
    @ConfigurationProperties("spring.datasource")
    public DataSource queryDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Qualifier("queryJdbcTemplate")
    JdbcTemplate queryJdbcTemplate(@Qualifier("queryDataSource")DataSource queryDataSource) {
        return new JdbcTemplate(queryDataSource);
    }
}
