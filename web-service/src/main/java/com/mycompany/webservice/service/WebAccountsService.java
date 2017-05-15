/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.webservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WebAccountsService {

    @Autowired
    @LoadBalanced
    private RestTemplate restTemplate;

    private String serviceURL;

    public WebAccountsService(String serviceURL){
        this.serviceURL = serviceURL.startsWith("http") ? serviceURL : "http://" + serviceURL;
    }

    @HystrixCommand(fallbackMethod = "getDefaultAccount")
    public void getAccountByAccountNumber(String accountNumber) {
        restTemplate.getForObject(serviceURL + "/accounts/{accountNumber}", Void.class, accountNumber);
    }

    public String getDefaultAccount() {
        return "Default Account";
    }

}
