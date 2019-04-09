package com.koali.action;

import com.koali.pojo.Card;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import java.util.Date;

/**
 * 动态参数封装之模型驱动
 */
public class Demo03Action extends ActionSupport implements ModelDriven<Card> {
    //模型注入
    private Card card = new Card() ;

    @Override
    public Card getModel() {
        return card;
    }

    public String findCard(){
        System.out.println(card.getCardNo()+","+card.getCardType()+","+card.getCardDate());
        return "success";
    }


}
