package com.koali.service;

import com.koali.pojo.Account;

import java.util.List;

public interface AccountService {
    public Account getAccountByName(String name) throws Exception;
    public void updateAccount(Account account,Double num);
    public void transferAccount(String decreaseName, String addName, Double num) throws Exception;
}
