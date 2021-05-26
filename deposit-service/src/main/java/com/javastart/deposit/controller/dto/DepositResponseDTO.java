package com.javastart.deposit.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class DepositResponseDTO {
    // сумма перевода
    private BigDecimal amount;
    // на какой аккаунт был сделан этот перевод
    private  String mail;

}
