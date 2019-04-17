package com.koali.dao;

import com.koali.pojo.Person;
import com.koali.pojo.PersonModel;

public interface PersonDao {

    public Person findUserById(int id);

    public PersonModel findModelByName1(String name);

    public PersonModel findModelByName2(String name);
}
