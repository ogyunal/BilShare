package com.bilshare.backend.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;

/**
 * The MyUserDetails class which extends the UserDetails class of Spring.
 * @author BilShare
 * @version 1.0
 */
public  class MyUserDetails implements UserDetails {

    // properties
    private String userName;
    private String password;
    private List<GrantedAuthority> authorities;

    // constructor
    public MyUserDetails(User user) {
        this.userName = user.getUsername();
        this.password = user.getPassword();
    }


    // methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}