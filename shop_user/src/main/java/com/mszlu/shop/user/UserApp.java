package com.mszlu.shop.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@Component
@ComponentScan({"com.mszlu.shop"})
@EnableSwagger2
public class UserApp {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class,args);
    }

}
