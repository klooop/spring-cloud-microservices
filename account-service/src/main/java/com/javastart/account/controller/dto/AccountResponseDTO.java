package com.javastart.account.controller.dto;

import com.javastart.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class AccountResponseDTO {
    private Long accountId;
    private String name;
    private String phone;
    private String email;
    private List<Long> bills;

    private OffsetDateTime creationDate;

    public AccountResponseDTO(Account account) {
        accountId=account.getAccountId();
        name= account.getName();
        phone = account.getPhone();
        email=account.getEmail();
        bills=account.getBills();
        creationDate=account.getCreationDate();
    }
}
