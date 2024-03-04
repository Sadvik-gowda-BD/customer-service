package com.bank.customerservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConf {

    @Bean
    @LoadBalanced // This is to identify the ip address and port number by application name (ACCOUNT-SERVICE)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
