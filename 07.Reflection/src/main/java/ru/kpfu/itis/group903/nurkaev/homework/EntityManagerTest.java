package ru.kpfu.itis.group903.nurkaev.homework;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import ru.kpfu.itis.group903.nurkaev.homework.manager.EntityManager;
import ru.kpfu.itis.group903.nurkaev.homework.models.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Shamil Nurkaev @nshamil
 * 11-903
 * Homework
 */

public class EntityManagerTest {
    public static void main(String[] args) throws IOException {
        // Database properties
        Properties properties = new Properties();
        properties.load(new FileReader("src/main/webapp/WEB-INF/properties/db.properties"));
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(properties.getProperty("db.url"));
        hikariConfig.setDriverClassName(properties.getProperty("db.driver.classname"));
        hikariConfig.setUsername(properties.getProperty("db.username"));
        hikariConfig.setPassword(properties.getProperty("db.password"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(properties.getProperty("db.hikari.max-pool-size")));
        HikariDataSource dataSource = new HikariDataSource(hikariConfig);

        // EntityManager test
        EntityManager entityManager = new EntityManager(dataSource);


        // createTable test
//        entityManager.createTable("user", User.class);


/*
        // save test
        User userShamil = User.builder()
                .id(1L)
                .firstName("Shamil")
                .lastName("Nurkaev")
                .isWorker(false)
                .build();
        entityManager.save("user", userShamil);
*/

        // findById test
        User userFoundById = entityManager.findById("user", User.class, Long.class, 1L);
        System.out.println(userFoundById);
    }
}
