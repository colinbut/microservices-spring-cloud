package com.mycompany.accountservice.accountservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class AccountServiceApplication {

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
}
