package com.xiaoyun.main.common;

public class Login {
    private String userName;
    private String password;
    private String authCode;
    //我只是添加一行注释
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuthCode() {
        return authCode;
    }

    public Login setAuthCode(String authCode) {
        this.authCode = authCode;
        return this;
    }
}
