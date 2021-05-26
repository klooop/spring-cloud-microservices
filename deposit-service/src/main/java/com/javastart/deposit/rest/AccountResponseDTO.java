package com.javastart.deposit.rest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDTO {
    private Long accountId;
    private String name;
    private String phone;
    private String email;
    private List<Long> bills;

    private OffsetDateTime creationDate;


}
