package com.security;

import com.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;

public class MyUserDetails implements UserDetails {

    private User user;
    private String userName;
    private String password;
    private String emailAddress;



    public MyUserDetails(User user) {
        this.user = user;
    }
    }



