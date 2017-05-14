/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.repository;

import com.mycompany.accountservice.accountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
