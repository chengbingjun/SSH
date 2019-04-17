package com.koali.dao;

import com.koali.pojo.Account;
import com.koali.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class AccountTest {
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountDao accountDao;

    @Test
    public void AccountDaoTest(){
        Account account = accountDao.getAccountByName("lisi");
        System.out.println(account);
        accountDao.changeBalance(account,-200.0);
        System.out.println(accountDao.getAccountByName("lisi"));
    }

    @Test
    public void AccountServiceTest(){
        Account account1 = accountDao.getAccountByName("lisi");
        Account account2 = accountDao.getAccountByName("zhangsan");
        System.out.println(account1);
        System.out.println(account2);
        try {
            accountService.transferAccount("zhangsan","lisi",200.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
