package com.org.users.ui.model;

public class AuthenticationRequestModel {

    private String username;
    private String password;

    public AuthenticationRequestModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public AuthenticationRequestModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
