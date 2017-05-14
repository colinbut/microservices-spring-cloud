/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.controller;

import com.mycompany.accountservice.accountservice.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity getAccount(@PathVariable Integer accountNumber) {
        return ResponseEntity.ok(accountRepository.findOne(accountNumber));
    }

}
