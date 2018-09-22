/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.controller;

import com.mycompany.accountservice.accountservice.dto.AccountDTO;
import com.mycompany.accountservice.accountservice.model.Account;
import com.mycompany.accountservice.accountservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Integer accountNumber) {

        log.info("Fetching account with accountNumber: {}", accountNumber);

        Account account = accountRepository.findOne(accountNumber);

        log.info("Found account: {} from Storage", account);

        AccountDTO accountDTO = AccountDTO.builder()
            .id(account.getId())
            .accountName(account.getAccountName())
            .accountDescription(account.getAccountDescription())
            .build();

        return ResponseEntity.ok(accountDTO);
    }

}
