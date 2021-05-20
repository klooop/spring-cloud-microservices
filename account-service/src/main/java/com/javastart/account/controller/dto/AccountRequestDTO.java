package com.javastart.account.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
// т к объект создает спринг, значит нам нужен конструктор без параметров
@NoArgsConstructor
public class AccountRequestDTO {
    private String name;
    private String phone;
    private String email;
    private List<Long> bills;
    private OffsetDateTime creationDate;
}
