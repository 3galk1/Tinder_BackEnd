package ru.liga.tinder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import ru.liga.tinder.controller.JdbcConnectionController;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
        PersistenceExceptionTranslationAutoConfiguration.class})
public class App implements CommandLineRunner {

    @Autowired
    private JdbcConnectionController springController;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        springController.getAllUser();
    }
}
