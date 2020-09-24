package com.org.users.ui.model;

import com.org.users.data.PhoneEntity;

import java.util.List;

public class UserResponseModel {

    private String name;
    private String mail;
    private String password;
    private List<PhoneEntity> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneEntity> phones) {
        this.phones = phones;
    }
}
