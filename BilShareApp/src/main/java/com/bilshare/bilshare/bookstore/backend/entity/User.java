package com.bilshare.bilshare.bookstore.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USERS")

public class User extends AbstractEntity implements Cloneable {

    @NotNull
    @NotEmpty
    @Column(name = "first_name")
    private String firstname = "";

    @NotNull
    @NotEmpty
    @Column(name = "last_name")
    private String lastname = "";

    @NotEmpty
    @NotNull
    @Column
    private String username = "";

    @Email
    @NotNull
    @NotEmpty
    @Column
    private String email = "";

    @NotEmpty
    @NotNull
    @Column
    private String password = "";

    public User (){
    }

    public User (String username){
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {

        this.firstname = firstname;
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

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
