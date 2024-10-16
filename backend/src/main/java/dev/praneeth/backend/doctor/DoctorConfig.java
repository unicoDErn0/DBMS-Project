package dev.praneeth.backend.doctor;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// import org.springframework.jdbc.core.JdbcTemplate;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DoctorConfig {

    // @Bean
    // public DataSource dataSource() {
    //     DriverManagerDataSource dataSource = new DriverManagerDataSource();
    //     dataSource.setUrl("jdbc:mysql://localhost:3306/your_database"); // Replace with your DB URL
    //     dataSource.setUsername("your_username"); // Replace with your DB username
    //     dataSource.setPassword("your_password"); // Replace with your DB password
    //     dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver"); // Adjust for your database
    //     return dataSource;
    // }

    // @Bean
    // public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    //     return new JdbcTemplate(dataSource);
    // }

    // @Bean
    // CommandLineRunner commandLineRunner(DoctorDao doctorDao) {
    //     return args -> {
    //         Doctor doctor1 = new Doctor("John", "Doe", "Cardiology", "9876543210", "john.doe@example.com", "12345");
    //         doctorDao.addDoctor(doctor1);
    //     };
    // }
}
