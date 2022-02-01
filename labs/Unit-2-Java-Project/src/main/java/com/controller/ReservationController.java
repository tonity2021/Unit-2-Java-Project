package com.controller;

import com.model.Reservation;
import com.repository.ReservationRepository;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")

public class ReservationController {

    private ReservationRepository reservationRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //    @GetMapping(path = "/hello")
//    public String helloWorld() {
//        return "Hello World";
//    }
//    @GetMapping(path = "/reservations/") //get all 'reservations' endpoint is working
//    public String getAllReservations() {
//        return "all reservations";
//    }

    @GetMapping("/reservations/")
    public List<Reservation> getReservations() {
        System.out.println("calling getReservations ==>");
        return reservationRepository.findAll();
    }
}