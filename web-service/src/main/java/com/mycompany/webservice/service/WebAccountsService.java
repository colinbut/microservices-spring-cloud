/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.webservice.service;

import com.mycompany.accountservice.accountservice.dto.AccountDTO;
import com.mycompany.webservice.controller.resource.AccountResource;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
        ResponseEntity<AccountDTO> responseEntity = restTemplate.getForEntity(serviceURL + "/accounts/{accountNumber}",
            AccountDTO.class, accountNumber);

        AccountDTO accountDTO = responseEntity.getBody();
        AccountResource accountResource = new AccountResource();
        accountResource.setId(accountDTO.getId());
        accountResource.setAccountName(accountDTO.getAccountName());
        accountResource.setAccountDescription(accountDTO.getAccountDescription());

        return accountResource;
    }

    public AccountResource getDefaultAccount() {
        AccountResource accountResource = new AccountResource();
        accountResource.setId(1);
        accountResource.setAccountName("Current Account");
        accountResource.setAccountDescription("The bank's current account offering");
        return accountResource;
    }

}
