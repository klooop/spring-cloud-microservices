package com.javastart.deposit.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//клиент который будет посылать http запросы(по сути это постман только внутри приложения)
@FeignClient(name="account-service")
public interface AccountServiceClient {
// сприг сам реализует наши методы
    // rest request to account
    @RequestMapping(value = "/accounts/{accountId}", method = RequestMethod.GET)
    AccountResponseDTO getAccountById(@PathVariable("accountId") Long accountId);
}
