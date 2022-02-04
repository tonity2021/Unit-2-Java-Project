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
    private String travel_dates;

    @JsonIgnore
    @OneToOne(mappedBy = "userProfile") //this column is owned by another entity
    private User user;


    public UserProfile(Long id, String firstName, String lastName, String travel_dates) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.travel_dates = travel_dates;
    }

    public UserProfile() {
    }

    public Long getId() {
        return id;
    }

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

    public String getTravel_dates() {return travel_dates;}

    public void setTravel_dates(String travel_dates) {this.travel_dates = travel_dates;}


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
                ", travel_dates='" + travel_dates + '\'' +
                '}';
    }

}

