package com.koali.action;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Date;

/**
 * 自定义类型转换器
 */
public class Demo04Action extends ActionSupport {
    private Date birthday;

    public String findDate(){
        System.out.println(birthday);
        return "success";
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
