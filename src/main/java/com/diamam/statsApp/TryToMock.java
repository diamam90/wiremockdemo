package com.diamam.statsApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TryToMock {

    public static void main(String[] args) {
        SpringApplication.run(TryToMock.class);
    }

}
