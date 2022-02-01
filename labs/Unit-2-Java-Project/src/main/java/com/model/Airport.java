package com.model;

import javax.persistence.*;

@Entity
@Table(name = "airport")
public class Airport {


    @Id //primary key
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    public Airport() {
    }

    public Airport(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id +
                ", departure_city='" + name + '\'' +
                ", address='" + address + '\'' +
//                ", isPublic=" + isPublic +
                '}';
    }


}