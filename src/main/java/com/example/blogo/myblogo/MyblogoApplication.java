package com.example.blogo.myblogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.blogo.myblogo.*"})
public class MyblogoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MyblogoApplication.class, args);
    }
}
