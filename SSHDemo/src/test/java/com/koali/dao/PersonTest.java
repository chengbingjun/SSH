package com.koali.dao;

import com.koali.pojo.Person;
import com.koali.pojo.PersonModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class PersonTest {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void findUserById(){
        Person person = personDao.findUserById(1);
        System.out.println(person.getPassword());
    }

    @Test
    public void savePerson(){
        Session session = sessionFactory.openSession();
        Transaction tr = session.beginTransaction();
        Person person = new Person();//瞬时
        person.setPassword("5896");
        person.setName("牛武");

        session.save(person);//持久化（是否在这一步打印insert语句和主键策略有关）
        person.setName("羊八");

        tr.commit();//游离
        session.close();
        sessionFactory.close();
    }

    @Test
    public void getPersonModel(){
        String name = "马文";
        PersonModel personModel = personDao.findModelByName1(name);
        System.out.println(personModel);
    }
}
