package com.controller;

import com.exceptions.InformationExistException;
import com.exceptions.InformationNotFoundException;
import com.model.Reservation;
import com.repository.ReservationRepository;
import com.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")

public class ReservationController {

    private ReservationService reservationService; //added this

//    @Autowired
//    public void setReservationRepository(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//    }

        @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello World";
    }
//    @GetMapping(path = "/reservations/") //get all 'reservations' endpoint is working
//    public String getAllReservations() {
//        return "all reservations";
//    }


//    //get all reservations
//    @GetMapping("/reservations/")//endpoint working
//    public List<Reservation> getReservation() {
//        System.out.println("calling getReservations ==>");
//        return reservationRepository.findAll();
//    }


    @GetMapping("/reservations")
    public List<Reservation> getReservations() {
        System.out.println("calling getReservations ==>");
        return reservationService.getReservations();
    }


    //get reservation by ID
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

    //create a new reservation
    @PostMapping("/reservation/")
    public Reservation createReservation(@RequestBody Reservation reservationObject) {
        System.out.println("calling createReservation ==>");

        Reservation reservation = reservationRepository.findByName(reservationObject.getName());
        if (reservation != null) {
            throw new InformationExistException("The following: " + reservation.getName() + " already exists");
        } else {
            return reservationRepository.save(reservationObject);
        }
    }

    //modify reservation by ID
    //update reservation
    //name(flight name) has to also be updated in order for this to work
    @PutMapping("/reservation/{reservationId}")
    public Reservation updateReservation(@PathVariable(value = "reservationId") Long reservationId, @RequestBody Reservation reservationObject) {
        System.out.println("calling updateReservation ==>");
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            if (reservationObject.getName().equals(reservation.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("The following: " + reservation.get().getName() + " already exists");
            } else {
                Reservation updateReservation = reservationRepository.findById(reservationId).get();
                updateReservation.setDeparture_city(reservationObject.getDeparture_city());
                updateReservation.setName(reservationObject.getName());
                updateReservation.setDestination(reservationObject.getDestination());
                updateReservation.setDeparture_time(reservationObject.getDeparture_time());
                updateReservation.setArrival_time(reservationObject.getArrival_time());
                updateReservation.setBoarding_gate(reservationObject.getBoarding_gate());
                updateReservation.setDeparture_airport(reservationObject.getDeparture_airport());
                updateReservation.setArrival_airport(reservationObject.getArrival_airport());
                updateReservation.setAirline_name(reservationObject.getAirline_name());
                return reservationRepository.save(updateReservation);
            }
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");


        }
    }

    //delete reservation
    @DeleteMapping("/reservations/{reservationId}")
    public Optional<Reservation> deleteReservation(@PathVariable(value = "reservationId") Long reservationId) {
        System.out.println("calling deleteReservation ==>");
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);

        if (reservation.isPresent()) {
            reservationRepository.deleteById(reservationId);
            return reservation;
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }
}