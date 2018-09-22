/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.webservice.mapper;

import com.mycompany.webservice.controller.resource.AccountResource;
import com.mycompany.webservice.dto.AccountDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class AccountMapper {

    public static AccountDTO resourceToDTO(AccountResource accountResource) {
        return AccountDTO.builder()
            .id(accountResource.getId())
            .accountName(accountResource.getAccountName())
            .accountDescription(accountResource.getAccountDescription())
            .build();
    }

    public static AccountResource DTOtoResource(AccountDTO accountDTO) {
        AccountResource accountResource = new AccountResource();
        accountResource.setId(accountDTO.getId());
        accountResource.setAccountName(accountDTO.getAccountName());
        accountResource.setAccountDescription(accountDTO.getAccountDescription());
        return accountResource;
    }
}
