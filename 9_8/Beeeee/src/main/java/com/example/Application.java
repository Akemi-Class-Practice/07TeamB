package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan("com.example.dao")
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
// NOTE
        log.info("|******************************************|");
        log.info("|*                                        *|");
        log.info("|*       希望不要报错！                    *|");
        log.info("|*                                        *|");
        log.info("|*                                        *|");
        log.info("|******************************************|");
    }
}