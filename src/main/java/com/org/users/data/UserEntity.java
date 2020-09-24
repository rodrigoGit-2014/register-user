package com.org.users.data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user")
public class UserEntity extends AuditEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String mail;
    private String password;
    private String token;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private Set<PhoneEntity> phones = new HashSet<>();

    public UserEntity() {
    }

    public UserEntity(String name, String mail, String password, String token, Set<PhoneEntity> phones) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.token = token;
        this.phones = phones;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Set<PhoneEntity> getPhones() {
        return phones;
    }

    public void setPhones(Set<PhoneEntity> phones) {
        this.phones = phones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
