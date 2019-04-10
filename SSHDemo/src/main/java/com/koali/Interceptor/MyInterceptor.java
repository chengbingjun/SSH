package com.koali.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor {
    //ActionInvocation是负责调用action整个过程的
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("进入了自定义拦截器。。。");
        /**
         * ActionInvocation对象的invoke方法就是调用相应的action
         * 在invoke之前可以做各种自已想定义的操作，例如
         * 判断用户有无登录。登录了就调用invoke方法，没登录就返回到登录界面，并给与一定提示。
         */
        return actionInvocation.invoke();
    }
}
