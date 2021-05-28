package com.javastart.accountService.service;

import com.javastart.account.exception.AccountNotFoundException;
import com.javastart.account.repository.AccountRepository;
import com.javastart.account.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

   @Mock
    AccountRepository accountRepository;
   @InjectMocks
   AccountService accountService;

    @Test(expected = AccountNotFoundException.class)
    public void accountServiceTestException() {
        accountService.getAccountById(null);
    }



}
