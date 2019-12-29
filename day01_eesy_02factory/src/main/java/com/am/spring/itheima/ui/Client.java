package com.am.spring.itheima.ui;

import com.am.spring.itheima.bean.BeanFactory;
import com.am.spring.itheima.service.IAccountService;

import java.util.stream.Stream;

public class Client {

    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 1).limit(5).forEach(i -> {
            IAccountService service = (IAccountService) BeanFactory.getBean("accountService");
            service.saveAccount();
        });
    }

}
