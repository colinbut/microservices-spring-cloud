/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.webservice.service;


import com.mycompany.webservice.controller.resource.AccountResource;
import com.mycompany.webservice.dto.AccountDTO;
import com.mycompany.webservice.mapper.AccountMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class WebAccountsService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private String serviceURL;

    public WebAccountsService(String serviceURL) {
        this.serviceURL = serviceURL.startsWith("http") ? serviceURL : "http://" + serviceURL;
    }

    @HystrixCommand(fallbackMethod = "getDefaultAccount")
    public AccountResource getAccountByAccountNumber(String accountNumber) {

        String urlEndpoint = serviceURL +  "/accounts/{accountNumber}";
        log.info("Making request to {}", urlEndpoint);

        ResponseEntity<AccountDTO> responseEntity = restTemplate.getForEntity(urlEndpoint, AccountDTO.class, accountNumber);

        AccountDTO accountDTO = Optional.ofNullable(responseEntity.getBody())
            .orElseThrow(() -> new NullPointerException("AccountDTO is null"));

        log.info("Received account {} from accounts-service", accountDTO);

        return AccountMapper.DTOtoResource(accountDTO);
    }

    public AccountResource getDefaultAccount(String accountNumber) {
        return AccountResource.builder()
            .id(Integer.parseInt(accountNumber))
            .accountName("Current Account")
            .accountDescription("The bank's current account offering")
            .build();
    }

}
