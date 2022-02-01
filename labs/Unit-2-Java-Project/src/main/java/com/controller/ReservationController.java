package com.controller;

import com.exceptions.InformationExistException;
import com.exceptions.InformationNotFoundException;
import com.model.Reservation;
import com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/reservations/")///endpoint working
    public List<Reservation> getReservation() {
        System.out.println("calling getReservations ==>");
        return reservationRepository.findAll();
    }

    @GetMapping(path = "/reservation/{reservationId}") //endpoint working
    public Optional getReservation(@PathVariable Long reservationId) {
        System.out.println("calling getReservations ==>");
        Optional reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            return reservation;
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }
    @PostMapping("/reservation/")
    public Reservation createReservation(@RequestBody Reservation reservationObject) {
        System.out.println("calling createReservation ==>");

        Reservation reservation = reservationRepository.findByName(reservationObject.getName());
        if (reservation != null) {
            throw new InformationExistException("reservation with booking id " + reservation.getName() + " already exists");
        } else {
            return reservationRepository.save(reservationObject);
        }
    }
    @PutMapping("/reservation/{reservationId}")
    public Reservation updateReservation(@PathVariable(value = "reservationId") Long reservationId, @RequestBody Reservation reservationObject) {
        System.out.println("calling updateReservation ==>");
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            if (reservationObject.getName().equals(reservation.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("reservation " + reservation.get().getName() + " already exists");
            } else {
                Reservation updateReservation = reservationRepository.findById(reservationId).get();
                updateReservation.setDeparture_city(reservationObject.getDeparture_city());
                updateReservation.setName(reservationObject.getName());
                updateReservation.setDestination(reservationObject.getDestination());
                updateReservation.setDeparture_time(reservationObject.getDeparture_time());
                updateReservation.setArrival_time(reservationObject.getArrival_time());
                updateReservation.setBoarding_gate(reservationObject.getBoarding_gate());
                return reservationRepository.save(updateReservation);
            }
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");


        }


    }









}