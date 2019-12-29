package com.am.spring.itheima.service;

import com.am.spring.itheima.domain.Account;

import java.util.List;

public interface IAccountService {

    void addAccount(Account account);

    void removeAccount(Integer accountId);

    void updateAccount(Account account);

    Account getAccount(Integer accountId);

    List<Account> getAllAccount();

}
