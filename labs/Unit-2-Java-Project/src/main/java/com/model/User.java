package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column //(unique = true)
    private String emailAddress;

    @Column
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

//    @OneToOne(cascade = CascadeType.ALL) //one and only one user has one profile
//    @JoinColumn(name = "profile_id", referencedColumnName = "id") //Connects the table via a foreign key (profile_id)
//    private UserProfile userProfile;
//Constructor for the User...followed by Getters and Setters

    public User(Long id, String userName, String emailAddress, String password) {
        this.id = id;
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    public UserProfile getUserProfile() {
//        return userProfile;
//    }
//
//    public void setUserProfile(UserProfile userProfile) {
//        this.userProfile = userProfile;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}