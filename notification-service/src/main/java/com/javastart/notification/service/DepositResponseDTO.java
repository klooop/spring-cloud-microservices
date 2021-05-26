package com.javastart.notification.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class DepositResponseDTO {
    // сумма перевода
    private BigDecimal amount;
    // на какой аккаунт был сделан этот перевод
    private  String mail;

}
