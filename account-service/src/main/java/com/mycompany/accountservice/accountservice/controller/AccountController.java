/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.controller;

import com.mycompany.accountservice.accountservice.controller.resource.CreateAccountRequest;
import com.mycompany.accountservice.accountservice.controller.resource.UpdateAccountRequest;
import com.mycompany.accountservice.accountservice.dto.AccountDTO;
import com.mycompany.accountservice.accountservice.model.Account;
import com.mycompany.accountservice.accountservice.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public ResponseEntity createAccount(@RequestBody @Valid CreateAccountRequest createAccountRequest) {
        Account account = new Account();
        account.setAccountName(createAccountRequest.getAccountName());
        account.setAccountDescription(createAccountRequest.getAccountDescription());

        accountRepository.save(account);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Integer accountNumber) {

        log.info("Fetching account with accountNumber: {}", accountNumber);

        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            log.info("Found account: {} from Storage", account);

            AccountDTO accountDTO = AccountDTO.builder()
                .id(account.getId())
                .accountName(account.getAccountName())
                .accountDescription(account.getAccountDescription())
                .build();

            return ResponseEntity.ok(accountDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{accountNumber}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Integer accountNumber,
                                                    @RequestBody UpdateAccountRequest updateAccountRequest) {
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            account.setAccountName(updateAccountRequest.getAccountName());
            account.setAccountDescription(updateAccountRequest.getAccountDescription());

            log.info("Updating account: {} from Storage", account);
            accountRepository.save(account);

            AccountDTO accountDTO = AccountDTO.builder()
                .id(account.getId())
                .accountName(account.getAccountName())
                .accountDescription(account.getAccountDescription())
                .build();

            return ResponseEntity.ok(accountDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{accountNumber}")
    public ResponseEntity deleteAccount(@PathVariable Integer accountNumber) {
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            log.info("Deleting account: {} from Storage", account);
            accountRepository.delete(account);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
