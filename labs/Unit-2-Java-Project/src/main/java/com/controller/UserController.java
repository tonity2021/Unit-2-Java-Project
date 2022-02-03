package com.controller;

import com.model.Request.LoginRequest;
import com.model.Reservation;
import com.model.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/users")
public class UserController {

    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//register and log-in user
    @PostMapping("/register/")
    public User createUser(@RequestBody User userObject){
        return userService.createUser(userObject);
    }
    @PostMapping("/login/")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }

//create a user profile
@PostMapping("/profile/")
public Profile createProfile(@RequestBody Profile profileObject) {
    System.out.println("calling createProfile ==>");
    return userService.createProfile(profileObject);
}


}