package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.mapper")
@SpringBootApplication
public class PhoneShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneShopApplication.class, args);
    }

}
