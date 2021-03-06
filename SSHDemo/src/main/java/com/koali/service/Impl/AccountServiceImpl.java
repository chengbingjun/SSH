package com.koali.service.Impl;

import com.koali.dao.AccountDao;
import com.koali.pojo.Account;
import com.koali.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    //找账户
    @Override
    public Account getAccountByName(String name) throws Exception {
        Account account = accountDao.getAccountByName(name);
        if(account==null){
            throw new Exception("无该用户");
        }
        return account;
    }

    //更新账户
    @Override
    public void updateAccount(Account account, Double num) {
        accountDao.changeBalance(account,num);
    }

    //转账操作
    @Transactional
    @Override
    public void transferAccount(String decreaseName, String addName, Double num) throws Exception {
        Account decrease = getAccountByName(decreaseName);
        Account add = getAccountByName(addName);
        updateAccount(decrease,-num);
        //int i = 1/0;不知道为什么使用了@Transaction注解，在手动添加异常的情况下
        // 还是出现了一个账户减少了，另一个账户不变的情况，在ssm中无此问题。
        updateAccount(add,num);
        System.out.println(getAccountByName(decreaseName));
        System.out.println(getAccountByName(addName));
    }


}
