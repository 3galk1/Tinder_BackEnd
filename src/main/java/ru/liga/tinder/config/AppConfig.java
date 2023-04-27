package ru.liga.tinder.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Data
@Configuration
public class AppConfig {
    @Value("${spring.datasource.url}")
    private String Url;
    @Value("${spring.datasource.name}")
    private String UserName;
    @Value("${spring.datasource.driver-class-name}")
    private String DriverClassName;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(DriverClassName);
        ds.setUrl(Url);
        ds.setUsername(UserName);
        return ds;
    }
}