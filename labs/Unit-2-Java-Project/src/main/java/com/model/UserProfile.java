package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "profiles") //Table column
public class UserProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private Integer phone_number;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile")
    private User user;


    public UserProfile(Long id, String firstName, String lastName, Integer phone_number) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
    }

    public UserProfile() {
    }

    //getters and setters
    public Long getId() { return id;}

    public void setId(Long id) {
        this.id = id;
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

    public Integer getPhone_number() { return phone_number; }

    public void setPhone_number(Integer phone_number) { this.phone_number = phone_number; }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserProfile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber ='" + phone_number + '\'' +
                '}';
    }

}

