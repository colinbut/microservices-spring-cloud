package com.mycompany.webaccountservice.webaccountservice;

import com.mycompany.webaccountservice.webaccountservice.config.WebAccountConfiguration;
import com.mycompany.webaccountservice.webaccountservice.service.WebAccountsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Import(WebAccountConfiguration.class)
public class WebAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAccountServiceApplication.class, args);
    }


}
