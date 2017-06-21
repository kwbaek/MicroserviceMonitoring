package com.nishant.mssample;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
 
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.nishant.mssample")
@SpringBootApplication
public class ProductInventoryApp {
     
    public static void main(String[] args) {
        SpringApplication.run(ProductInventoryApp.class, args);
    }
}
