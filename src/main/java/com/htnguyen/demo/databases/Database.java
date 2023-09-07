package com.htnguyen.demo.databases;

import com.htnguyen.demo.models.Product;
import com.htnguyen.demo.repositories.ProductRepositories;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {

    private static final Logger logger = LoggerFactory.getLogger(Database.class);

    @Bean
    CommandLineRunner initDataBase(ProductRepositories productRepositories) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product productA = new Product("Iphone1", 2022, 15000.6, "");
                Product productB = new Product("Iphone2", 2022, 1500.6, "");
                Product productC = new Product("Iphone3", 2022, 150.6, "");
                Product productD = new Product("Iphone4", 2022, 1500000.6, "");

                logger.info("insert data" + productRepositories.save(productA));
                logger.info("insert data" + productRepositories.save(productB));
                logger.info("insert data" + productRepositories.save(productC));
                logger.info("insert data" + productRepositories.save(productD));

            }
        };
    }
}