package com.koali.action;

/**
 * Struts入门实例
 */
public class Demo01Action {
    public String execute(){
        System.out.println("访问到了");
        return "success";
    }
}
