package com.mszlu.shop.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @author 86131
 * date 2021/12/17 03:22:37
 * @description
 */
@Configuration
public class ResttemplateConfig {
    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory requestFactory){
        return new RestTemplate(requestFactory);
    }

    @Bean
    public ClientHttpRequestFactory requestFactory(){
        return new SimpleClientHttpRequestFactory();
    }

}
