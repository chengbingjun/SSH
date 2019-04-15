package com.koali.dao.Impl;

import com.koali.dao.PersonDao;
import com.koali.pojo.Person;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {
    @Override
    public Person findUserById(int id) {
        return this.getHibernateTemplate().get(Person.class, id);
    }

}
