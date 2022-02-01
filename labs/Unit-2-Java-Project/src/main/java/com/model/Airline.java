package com.model;

import javax.persistence.*;

@Entity
@Table(name = "airline")

public class Airline {

    @Id //primary key
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Airline() {
    }


    public Airline(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Airline" +
                "id='" + id +
                ", name='" + name + '\'' +
//                ", isPublic=" + isPublic +
                '}';
    }


}