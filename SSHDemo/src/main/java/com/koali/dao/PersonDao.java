package com.koali.dao;

import com.koali.pojo.Person;
import com.koali.pojo.User;

public interface PersonDao {
    public Person findUserById(int id);
}
