package com.javastart.account.service;

import com.javastart.account.entity.Account;
import com.javastart.account.exception.AccountNotFoundException;
import com.javastart.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountById(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(()->new AccountNotFoundException("Unable to find account with id: "+accountId));
    }
    public Long createAccount(String name, String phone, String email, List<Long> bills) {
        Account account = new Account(name,phone, email, OffsetDateTime.now(),bills);
        return accountRepository.save(account).getAccountId();
    }

    public Account updateAccount(Long acccountId, String name,
                                 String phone, String email, List<Long> bills) {
        Account account = new Account();
        account.setAccountId(acccountId);
        account.setName(name);
        account.setPhone(phone);
        account.setEmail(email);
        account.setCreationDate(OffsetDateTime.now());
        account.setBills(bills);
        return accountRepository.save(account);
    }

    public Account deleteAccount(Long accountId) {
        Account deleteAccount = getAccountById(accountId);
        accountRepository.deleteById(accountId);
        return deleteAccount;
    }
}
