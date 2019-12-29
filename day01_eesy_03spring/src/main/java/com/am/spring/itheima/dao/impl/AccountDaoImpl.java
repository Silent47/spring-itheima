package com.am.spring.itheima.dao.impl;

import com.am.spring.itheima.dao.IAccountDao;

/**
 * @author Love
 */
public class AccountDaoImpl implements IAccountDao {

    private int accountCount = 0;

    @Override
    public void saveAccount() {
        ++this.accountCount;
        System.out.printf("Dao %s has saved account count: %d.\n", this, accountCount);
    }
}
