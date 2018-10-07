/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.webservice.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountDTO {
    private int id;
    private String accountName;
    private String accountDescription;
}
