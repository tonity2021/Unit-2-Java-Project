package com.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")   // create a new table called users
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String user_name;

    @Column
    private String email;

    @Column
    private String password;

    public User() {
    }

    //constructor

    public User(Long id, String user_name, String email, String password) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}


