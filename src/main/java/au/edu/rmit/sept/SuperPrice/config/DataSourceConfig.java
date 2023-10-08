package au.edu.rmit.sept.SuperPrice.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;


/**
 * DataSourceConfig class handles the configuration of the DataSource object.
 * Uses the DataSourceBuilder class to create a DataSource object.
 */
@Configuration
public class DataSourceConfig {
    @Bean
    public static DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://127.0.0.1:3306/mysql")
                .username("root")
                .password("password")
                .build();
    }
}
