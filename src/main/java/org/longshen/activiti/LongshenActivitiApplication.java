package org.longshen.activiti;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LongshenActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LongshenActivitiApplication.class, args);
    }

}
