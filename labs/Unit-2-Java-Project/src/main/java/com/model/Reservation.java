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
    private String departure_airport;

    @Column
    private String arrival_airport;

    @Column
    private String airline_name;

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
    private String travel_dates;

    //many reservations belong to a user
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    public Reservation() {
    }

    public Reservation(Long id, String name, String departure_airport, String arrival_airport, String airline_name, String departure_city, String destination, int departure_time, int arrival_time, String boarding_gate, String travel_dates) {
        this.id = id;
        this.name = name;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.airline_name = airline_name;
        this.departure_city = departure_city;
        this.destination = destination;
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.boarding_gate = boarding_gate;
        this.travel_dates = travel_dates;

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

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }

    public String getAirline_name() {
        return airline_name;
    }

    public void setAirline_name(String airline_name) {
        this.airline_name = airline_name;
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

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getTravel_dates() { return travel_dates; }

    public void setTravel_dates(String travel_dates) { this.travel_dates = travel_dates; }

    @Override
    public String toString() {
        return "Reservation{" +
                "id='" + id +
                ", booking_id='" + name + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                ", airline='" + airline_name + '\'' +
                ", departure_city='" + departure_city + '\'' +
                ", destination='" + destination + '\'' +
                ", departure_time='" + departure_time +
                ", arrival_time='" + arrival_time + '\'' +
                ", boarding_gate='" + boarding_gate + '\'' +
                '}';
    }


}