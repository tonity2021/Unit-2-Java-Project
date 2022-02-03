package com.controller;

import com.exceptions.InformationExistException;
import com.exceptions.InformationNotFoundException;
import com.model.Reservation;
import com.model.UserProfile;
import com.repository.ReservationRepository;
import com.security.MyUserDetails;
import com.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

//    @GetMapping(path = "/hello/")
//    public String helloWorld() {
//        return "Hello World";
//    }
//    @GetMapping(path = "/reservations/") //get all 'reservations' endpoint is working
//    public String getAllReservation() {
//        return "all reservations";
//    }


    //get all reservations
//    @GetMapping("/reservations/")//endpoint working
//    public List<Reservation> getReservation() {
//        System.out.println("calling getReservations ==>");
//        return reservationRepository.findAll();
//    }

//GET ALL RESERVATIONS (done)
    @GetMapping("/reservations/")
    public List<Reservation> getReservations() {
        System.out.println("calling getReservations ==>");
        return reservationService.getAllReservations();
    }


    //get reservation by ID
//    @GetMapping(path = "/reservation/{reservationId}") //endpoint working
//    public Optional getReservation(@PathVariable Long reservationId) {
//        System.out.println("calling getReservations ==>");
//        Optional reservation = reservationRepository.findById(reservationId);
//        if (reservation.isPresent()) {
//            return reservation;
//        } else {
//            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
//        }
//    }

    //GET RESERVATION BY ID (done)
    @GetMapping(path = "/reservation/{reservationId}")
    public Optional<Reservation> getReservation(@PathVariable Long reservationId) {

        return reservationService. getReservation(reservationId);
    }

//    @PutMapping("/reservations/{reservationId}")
//    public Reservation updateReservation(@PathVariable(
//            value = "reservationId") Long reservationId, @RequestBody Reservation reservationObject) {
//        System.out.println("calling updateReservation ==>");
//        return reservationService.updateReservation(reservationId, reservationObject);
//    }


    //create a new reservation
//    @PostMapping("/reservation/")
//    public Reservation createReservation(@RequestBody Reservation reservationObject) {
//        System.out.println("calling createReservation ==>");
//
//        Reservation reservation = reservationRepository.findByName(reservationObject.getName());
//        if (reservation != null) {
//            throw new InformationExistException("The following: " + reservation.getName() + " already exists");
//        } else {
//            return reservationRepository.save(reservationObject);
//        }
//    }

    //CREATE RESERVATION (done)
    @PostMapping("/reservation/")
    public Reservation createReservation(@RequestBody Reservation reservationObject) {
        System.out.println("calling createReservation ==>");
        return reservationService.createReservation(reservationObject);
    }

//    @PostMapping("/userProfile/")
//    public UserProfile createProfile(@RequestBody UserProfile userProfileObject) {
//        System.out.println("calling createProfile==>");
//        return reservationService.createProfile(userProfileObject);
//    }
//



    //modify reservation by ID
    //update reservation
    //name(flight name) has to also be updated in order for this to work
//    @PutMapping("/reservation/{reservationId}")
//    public Reservation updateReservation(@PathVariable(value = "reservationId") Long reservationId, @RequestBody Reservation reservationObject) {
//        System.out.println("calling updateReservation ==>");
//        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
//        if (reservation.isPresent()) {
//            if (reservationObject.getName().equals(reservation.get().getName())) {
//                System.out.println("Same");
//                throw new InformationExistException("The following: " + reservation.get().getName() + " already exists");
//            } else {
//                Reservation updateReservation = reservationRepository.findById(reservationId).get();
//                updateReservation.setDeparture_city(reservationObject.getDeparture_city());
//                updateReservation.setName(reservationObject.getName());
//                updateReservation.setDestination(reservationObject.getDestination());
//                updateReservation.setDeparture_time(reservationObject.getDeparture_time());
//                updateReservation.setArrival_time(reservationObject.getArrival_time());
//                updateReservation.setBoarding_gate(reservationObject.getBoarding_gate());
//                updateReservation.setDeparture_airport(reservationObject.getDeparture_airport());
//                updateReservation.setArrival_airport(reservationObject.getArrival_airport());
//                updateReservation.setAirline_name(reservationObject.getAirline_name());
//                return reservationRepository.save(updateReservation);
//            }
//        } else {
////            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
//
//
//        }
//UPDATE
    @PutMapping("/reservation/{reservationId}/") //HAVE TO CHANGE THE NAME WHEN YOU UPDATE IT
    public Reservation updateReservation(@PathVariable(value = "reservationId") Long reservationId, @RequestBody Reservation reservationObject){
        System.out.println("calling updateReservation ==>");
        return reservationService.updateReservation(reservationId, reservationObject);
    }

//    }

    //delete reservation
//    @DeleteMapping("/reservations/{reservationId}")
//    public Optional<Reservation> deleteReservation(@PathVariable(value = "reservationId") Long reservationId) {
//        System.out.println("calling deleteReservation ==>");
//        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
//
//        if (reservation.isPresent()) {
//            reservationRepository.deleteById(reservationId);
//            return reservation;
//        } else {
//            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
//        }
//    }

//DELETE BY ID (working)
    @DeleteMapping("/reservation/{reservationId}")
    public Optional<Reservation> deleteReservation(@PathVariable(value = "reservationId") Long reservationId) {
        System.out.println("calling deleteRez ==>");
        return reservationService.deleteReservation(reservationId);
    }




}