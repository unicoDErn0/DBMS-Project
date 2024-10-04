package dev.praneeth.backend;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    // Configure DataSource bean
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Update with your DB driver
        dataSource.setUrl("jdbc:mysql://localhost:3306/dbms?useSSL=false&serverTimezone=UTC"); // Update with your DB URL
        dataSource.setUsername("praneeth"); // Replace with your DB username
        dataSource.setPassword("pckc"); // Replace with your DB password
        return dataSource;
    }

    // Configure JdbcTemplate bean
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
