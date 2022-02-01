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

    @Column
    private int phoneNumber;


    public User() {
    }


    //constructor

    public User(Long id, String name, String email, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +

                '}';
    }

}


