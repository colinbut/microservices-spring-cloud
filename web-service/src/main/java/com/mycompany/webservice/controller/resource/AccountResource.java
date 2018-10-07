/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.webservice.controller.resource;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AccountResource {
    private int id;
    private String accountName;
    private String accountDescription;
}
