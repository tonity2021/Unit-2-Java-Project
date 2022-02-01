package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

//table columns

    @Id //primary key
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String departure_city;

    @Column
    private String destination;

    @Column
    private int departure_time;

    @Column
    private int arrival_time;

    @Column
    private String boarding_gate;

    @Column
    private String airline_name;

    @Column
    private String airport_name;

    public Reservation() {
    }


    public Reservation(Long id, String name, String airport_name, String airline_name, String departure_city, String destination, int departure_time, int arrival_time, String boarding_gate) {
        this.id = id;
        this.name = name;
        this.airport_name = airport_name;
        this.airline_name = airline_name;
        this.departure_city = departure_city;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.boarding_gate = boarding_gate;

    }


    //getters and setters
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

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
    }

    public String getAirport_name() {
        return airport_name;
    }

    public void setAirport_name(String airport_name) {
        this.airport_name = airport_name;
    }


    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(int departure_time) {
        this.departure_time = departure_time;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getBoarding_gate() {
        return boarding_gate;
    }

    public void setBoarding_gate(String boarding_gate) {
        this.boarding_gate = boarding_gate;
    }


    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id +
                ", booking_id='" + name + '\'' +
                ", airport='" + airport_name + '\'' +
                ", airline='" + airline_name + '\'' +
                ", departure_city='" + departure_city + '\'' +
                ", destination='" + destination + '\'' +
                ", departure_time='" + departure_time +
                ", arrival_time='" + arrival_time + '\'' +
                ", boarding_gate='" + boarding_gate + '\'' +
//                ", isPublic=" + isPublic +
                '}';
    }


}