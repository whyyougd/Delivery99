package com.sparta.delivery99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Delivery99Application {

    public static void main(String[] args) {
        SpringApplication.run(Delivery99Application.class, args);
    }

}
