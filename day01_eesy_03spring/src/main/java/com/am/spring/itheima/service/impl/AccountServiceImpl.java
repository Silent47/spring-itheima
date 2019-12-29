package com.am.spring.itheima.service.impl;

import com.am.spring.itheima.dao.IAccountDao;
import com.am.spring.itheima.service.IAccountService;

/**
 * @author Love
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = null;

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
