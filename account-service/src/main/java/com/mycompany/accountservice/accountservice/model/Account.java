/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "account_name", length = 25)
    private String accountName;

    @Column(name = "account_description", length = 50)
    private String accountDescription;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountDescription() {
        return accountDescription;
    }

    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        return new EqualsBuilder()
            .append(id, account.id)
            .append(accountName, account.accountName)
            .append(accountDescription, account.accountDescription)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(id)
            .append(accountName)
            .append(accountDescription)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
            .append("id", id)
            .append("accountName", accountName)
            .append("accountDescription", accountDescription)
            .toString();
    }
}
