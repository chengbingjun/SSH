package com.koali.dao.Impl;

import com.koali.dao.AccountDao;
import com.koali.pojo.Account;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AccounDaoImpl extends HibernateDaoSupport implements AccountDao {
    @Override
    public Account getAccountByName(String name) {
        String sql = "select * from account where name = :name";
        SQLQuery query = this.getSessionFactory().openSession().createSQLQuery(sql).addEntity(Account.class);
        query.setParameter("name",name);
        List<Account> accounts = query.list();
        if(accounts.size()>0){
            return accounts.get(0);
        }else{
            return null;
        }
    }

    @Override
    public void changeBalance(Account account, Double num) {
        String sql = "update account set balance = balance + :num where name = :name";
        SQLQuery query = this.getSessionFactory().openSession().createSQLQuery(sql);
        query.setParameter("num",num);
        query.setParameter("name",account.getName());
        query.executeUpdate();
    }

}
