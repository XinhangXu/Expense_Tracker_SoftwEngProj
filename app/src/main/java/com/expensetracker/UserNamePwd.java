package com.expensetracker;

import android.app.Application;

// a global class to store user name and password


public class UserNamePwd extends Application {

    String name = "ExpenseTracker", pwd = "123456"; //this is default name n pwd

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
