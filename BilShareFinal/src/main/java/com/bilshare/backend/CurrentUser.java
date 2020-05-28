package com.bilshare.backend;

import com.bilshare.backend.entity.User;

public class CurrentUser {
    private  static String username;
    private static String password;

    public CurrentUser()
    {
    }

    public static void setUser(String usernamex, String passwordx)
    {
        username = usernamex;
        password = passwordx;
    }

    public static User getUser()
    {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        return u;

    }
}
