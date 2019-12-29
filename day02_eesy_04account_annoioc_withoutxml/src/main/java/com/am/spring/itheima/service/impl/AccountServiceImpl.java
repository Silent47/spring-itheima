package com.am.spring.itheima.service.impl;

import com.am.spring.itheima.dao.IAccountDao;
import com.am.spring.itheima.domain.Account;
import com.am.spring.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
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
