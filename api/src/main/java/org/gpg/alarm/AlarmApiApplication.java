package org.gpg.alarm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlarmApiApplication {
    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application,core,external");
        SpringApplication.run(AlarmApiApplication.class, args);
    }
}
