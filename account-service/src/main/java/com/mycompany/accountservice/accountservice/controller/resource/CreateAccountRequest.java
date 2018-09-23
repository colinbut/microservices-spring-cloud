/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.accountservice.accountservice.controller.resource;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
public class CreateAccountRequest {

    @NotEmpty
    private String accountName;

    @NotEmpty
    private String accountDescription;
}
