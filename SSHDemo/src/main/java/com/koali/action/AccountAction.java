package com.koali.action;

import com.koali.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountAction {
    @Autowired
    public AccountService accountService;

    private String decreaseName;
    private String addName;
    private Double num;

    public String getDecreaseName() {
        return decreaseName;
    }

    public void setDecreaseName(String decreaseName) {
        this.decreaseName = decreaseName;
    }

    public String getAddName() {
        return addName;
    }

    public void setAddName(String addName) {
        this.addName = addName;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public String changeBalance(){
        try {
            accountService.transferAccount(decreaseName,addName,num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
