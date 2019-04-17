package com.koali.dao.Impl;

import com.koali.dao.PersonDao;
import com.koali.pojo.Person;
import com.koali.pojo.PersonModel;
import com.koali.util.ConvertUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {
    @Override
    public Person findUserById(int id) {
        return this.getHibernateTemplate().get(Person.class, id);
    }

    @Override
    public PersonModel findModelByName1(String name) {
        String hql = "select new com.koali.pojo.PersonModel(p.id,p.name,p.password,p.birthday,u.sex,u.loginName,u.loginPwd)" +
                "from Person p,User u where p.name = u.name and p.name = :name";
        Query query = this.getSessionFactory().openSession().createQuery(hql);
        query.setParameter("name",name);
        List<PersonModel> personModels = query.list();
        if(personModels.size()>0){
            return  personModels.get(0);
        }else{
            return null;
        }
    }

    @Override
    public PersonModel findModelByName2(String name) {
        String sql = "select p.id,p.name,p.password,p.birthday,u.sex,u.login_name,u.login_pwd \n" +
                "from person p inner join user u on p.name = u.name\n" +
                "where p.name = :name";
        SQLQuery query = this.getSessionFactory().openSession().createSQLQuery(sql);
        query.setParameter("name",name);
        List list = query.list();
        List<PersonModel> personModels = new ArrayList<PersonModel>();
        for(int i=0;i<list.size();i++){
            PersonModel personModel = new PersonModel();
            Object[] values = (Object[]) list.get(i);
            personModel = ConvertUtils.convert(personModel,values);
            personModels.add(personModel);
        }
        if(personModels.size()>0){
            return personModels.get(0);
        }
        return null;
    }

}
