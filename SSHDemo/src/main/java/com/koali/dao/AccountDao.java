package com.koali.dao;

import com.koali.pojo.Account;

public interface AccountDao {
    public Account getAccountByName(String name);

    public void changeBalance(Account account,Double num);
}
