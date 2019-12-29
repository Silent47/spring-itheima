package com.am.spring.itheima.dao.impl;

import com.am.spring.itheima.bean.BeanFactory;
import com.am.spring.itheima.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
