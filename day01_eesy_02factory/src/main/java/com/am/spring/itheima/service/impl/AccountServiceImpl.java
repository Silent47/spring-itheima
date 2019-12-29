package com.am.spring.itheima.service.impl;

import com.am.spring.itheima.service.IAccountService;

/**
 * @author Love
 */
public class AccountServiceImpl implements IAccountService {

    private int accountCount = 0;

    @Override
    public void saveAccount() {
        ++this.accountCount;
        System.out.printf("Service %s has saved account count: %d.\n", this, accountCount);
    }
}
