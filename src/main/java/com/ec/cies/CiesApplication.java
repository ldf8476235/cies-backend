package com.ec.cies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
//@EnableAsync
public class CiesApplication {
    public static void main(String[] args) {
        SpringApplication.run(CiesApplication.class, args);
    }
}
