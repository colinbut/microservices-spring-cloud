package com.mycompany.accountservice.accountservice.controller;

import com.mycompany.accountservice.accountservice.dto.AccountDTO;
import com.mycompany.accountservice.accountservice.model.Account;
import com.mycompany.accountservice.accountservice.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

// TODO replace with spring unit-integration tests
@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountController classUnderTest = new AccountController();

    @Test
    public void getAccount() {

        Account account = new Account();
        account.setId(1);
        account.setAccountName("AccountName");
        account.setAccountDescription("AccountDescription");

        int accountNumber = 1;

        Mockito.when(accountRepository.findOne(accountNumber)).thenReturn(account);

        ResponseEntity<AccountDTO> responseEntity = classUnderTest.getAccount(accountNumber);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        AccountDTO accountDTO = responseEntity.getBody();
        assertThat(accountDTO).isNotNull();
        assertThat(accountDTO.getId()).isEqualTo(1);
        assertThat(accountDTO.getAccountName()).isEqualTo("AccountName");
        assertThat(accountDTO.getAccountDescription()).isEqualTo("AccountDescription");
        Mockito.verify(accountRepository, Mockito.times(1)).findOne(accountNumber);
    }
}