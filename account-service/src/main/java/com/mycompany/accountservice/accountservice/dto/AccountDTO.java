/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.dto;

public class AccountDTO {
    private int id;
    private String accountName;
    private String accountDescription;

    public int getId() {
        return id;
    }

    public AccountDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public AccountDTO setAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public AccountDTO setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
        return this;
    }
}
