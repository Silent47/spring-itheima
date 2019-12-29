package com.am.spring.itheima.service.impl;

import com.am.spring.itheima.bean.BeanFactory;
import com.am.spring.itheima.dao.IAccountDao;
import com.am.spring.itheima.service.IAccountService;

/**
 * @author Love
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
