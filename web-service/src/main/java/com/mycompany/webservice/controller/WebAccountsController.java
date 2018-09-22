/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.webservice.controller;

import com.mycompany.webservice.controller.resource.AccountResource;
import com.mycompany.webservice.service.WebAccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web-accounts")
public class WebAccountsController {

    @Autowired
    private WebAccountsService webAccountsService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountResource> getAccount(@PathVariable String accountNumber) {
        AccountResource accountResource = webAccountsService.getAccountByAccountNumber(accountNumber);
        return ResponseEntity.ok(accountResource);
    }
}
