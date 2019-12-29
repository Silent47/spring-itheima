package com.am.spring.itheima.service.impl;

import com.am.spring.itheima.dao.IAccountDao;
import com.am.spring.itheima.domain.Account;
import com.am.spring.itheima.service.IAccountService;

import java.util.List;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    @Override
    public void addAccount(Account account) {
        accountDao.addAccount(account);
    }

    @Override
    public void removeAccount(Integer accountId) {
        accountDao.removeAccount(accountId);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public Account getAccount(Integer accountId) {
        return accountDao.getAccount(accountId);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountDao.getAllAccount();
    }
}
