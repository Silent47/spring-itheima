package com.am.spring.itheima.dao;

import com.am.spring.itheima.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountDao {

    void addAccount(Account account);

    void removeAccount(Integer accountId);

    void updateAccount(Account account);

    Account getAccount(Integer accountId);

    List<Account> getAllAccount();

}
