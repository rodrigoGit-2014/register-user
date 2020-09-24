package com.org.users.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class UserRequestModel {
    @NotNull(message = "Name can not be null")
    @Size(min = 2, max = 20)
    private String name;
    @Email(message = "Mail is not valid")
    private String mail;
    @Pattern(regexp = "^[A-Z][a-z]+[0-9]{2}$", message = "password must contain 1 uppercases letter, any lowercases letter and two numbers")
    private String password;
    private Date created;
    private Date updated;

    private List<PhoneRequestModel> phones;

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

    public List<PhoneRequestModel> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneRequestModel> phones) {
        this.phones = phones;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
