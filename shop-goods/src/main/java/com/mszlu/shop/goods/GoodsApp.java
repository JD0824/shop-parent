package com.mszlu.shop.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GoodsApp {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApp.class);
    }
}
