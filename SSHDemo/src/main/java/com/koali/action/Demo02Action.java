package com.koali.action;

import com.koali.pojo.Card;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 动态参数封装之属性驱动
 */
public class Demo02Action extends ActionSupport{

    private String username;

    private Card card = new Card();

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String findUser(){
        System.out.println("username:"+username);
        return "success";
    }

    public String findCard(){
        System.out.println("cardNo："+card.getCardNo()+";"+"cardType:"+card.getCardType());
        return "success";
    }

    public void validate(){
        System.out.println("validate");
    }

    public void validateFindUser(){
        System.out.println("validateFindUser");
        if(username == null || username.trim().equals("")||username.length()==0){
            addFieldError("username","请输入有效用户名");
        }
    }
}
