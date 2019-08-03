package com.imis.frame;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.imis"})
@MapperScan(basePackages = "com.imis.project.*.dao")
public class StartApplication {
    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class,args);
    }

}