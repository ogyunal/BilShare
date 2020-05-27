package com.bilshare.backend.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * The User Class
 * @author BilShare
 * @version 1.0
 */
@Entity
@Table(name = "USERS")
public class User extends AbstractEntity implements Cloneable {

    // properties
    @NotNull
    @Size(min = 2, max = 255)
    @Column(unique = true ,name = "username")
    private String username;

    @Size(min = 2, max = 255)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(max = 255)
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Size(max = 255)
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Email
    @Column(name = "email")
    private String email;

    // constructor
    public User() {
    }

    // methods
    /**
     * This method gets password of a user
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the password of a user
     * @param password is the desired password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method gets password of a user
     * @return the password of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method sets the fitstName of a user
     * @param firstName is the desired firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method gets the lastName of a user
     * @return the password of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method sets the lastName of a user
     * @param lastName is the desired lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method gets the username of a user
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets the username of a user
     * @param username is the desired username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method gets the email of a user
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the email of a user
     * @param email is the desired email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}