package com.shreekar.springjwtsecurity.models;


public class AuthRequest {
    private  String userName;
    private String password;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public AuthRequest() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
