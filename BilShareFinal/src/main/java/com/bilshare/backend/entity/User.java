package com.bilshare.backend.entity;

import com.bilshare.backend.data.AvatarImage;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

@Entity
@Table(name = "USERS")
public class User extends AbstractEntity implements Cloneable {

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


    //@Column(name = "avatar_image")
    //private AvatarImage avatar;

    //@NotBlank
    //@Size(max = 255)
    //@Column(name = "role")
    //private String role;

    //private boolean locked = false;

    //@PrePersist
    //@PreUpdate
    //private void prepareData(){
    //this.username = username == null ? null : username.toLowerCase();
    //}

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /*public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    /*public AvatarImage getAvatar() {
        return avatar;
    }

    public void setAvatar(AvatarImage avatar) {
        this.avatar = avatar;
    }*//*

    *//*public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }*//*

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        User that = (User) o;
        return //locked == that.locked &&
                Objects.equals(username, that.username) &&
                        Objects.equals(firstName, that.firstName) &&
                        Objects.equals(lastName, that.lastName);
        //&&
        //Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, firstName, lastName
                //role,
                //locked
        );
    }*/
}