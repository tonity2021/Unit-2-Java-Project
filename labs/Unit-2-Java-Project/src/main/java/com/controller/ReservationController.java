package com.controller;


import com.model.Reservation;
import com.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
public class ReservationController {

    private ReservationService reservationService;


    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    //hello world
    //   @GetMapping(path = "/hello/")
    //    public String helloWorld() {
    //        return "Hello World";
    //}

    //get all reservations
    @GetMapping("/reservations/")
    public List<Reservation> getReservations() {
        System.out.println("calling getReservations ==>");
        return reservationService.getAllReservations();
    }

    //get reservation by ID
    @GetMapping(path = "/reservation/{reservationId}")
    public Optional<Reservation> getReservation(@PathVariable Long reservationId) {
        return reservationService.getReservation(reservationId);
    }


    //create a new reservation
    @PostMapping("/reservation/")
    public Reservation createReservation(@RequestBody Reservation reservationObject) {
        System.out.println("calling createReservation ==>");
        return reservationService.createReservation(reservationObject);
    }


    //modify reservation by ID
    @PutMapping("/reservation/{reservationId}/")
    public Reservation updateReservation(@PathVariable(value = "reservationId") Long reservationId, @RequestBody Reservation reservationObject) {
        System.out.println("calling updateReservation ==>");
        return reservationService.updateReservation(reservationId, reservationObject);
    }


    //delete reservation by ID
    @DeleteMapping("/reservation/{reservationId}")
    public Optional<Reservation> deleteReservation(@PathVariable(value = "reservationId") Long reservationId) {
        System.out.println("calling deleteRez ==>");
        return reservationService.deleteReservation(reservationId);
    }

}