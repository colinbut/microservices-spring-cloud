/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AccountDTO {
    private int id;
    private String accountName;
    private String accountDescription;
}
