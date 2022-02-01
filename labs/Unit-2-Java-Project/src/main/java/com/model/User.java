package com.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")   // create a new table called users
public class User {

    @Id // @Id means primary key
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY) // equivalent to SERIAL in SQL
    private Long id;

    @Column
    private String name;

    @Column
    private String email;


    public User() {
    }


    //constructor

    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}


