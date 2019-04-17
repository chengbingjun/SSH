package com.koali.pojo;

import java.util.Date;

public class PersonModel {
    private Integer id;
    private String name;
    private String passeword;
    private Date birthday;
    private String sex;
    private String loginName;
    private String loginPwd;

    public PersonModel(Integer id, String name, String passeword,Date birthday, String sex, String loginName, String loginPwd) {
        this.id = id;
        this.name = name;
        this.passeword = passeword;
        this.sex = sex;
        this.loginName = loginName;
        this.loginPwd = loginPwd;
        this.birthday = birthday;
    }

    public PersonModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPasseword() {
        return passeword;
    }

    public void setPasseword(String passeword) {
        this.passeword = passeword;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passeword='" + passeword + '\'' +
                ", sex='" + sex + '\'' +
                ", loginName='" + loginName + '\'' +
                ", loginPwd='" + loginPwd + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
