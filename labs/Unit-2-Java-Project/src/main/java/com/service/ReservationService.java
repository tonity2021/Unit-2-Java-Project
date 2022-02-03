package com.service;

import com.exceptions.InformationExistException;
import com.exceptions.InformationNotFoundException;
import com.model.Reservation;
import com.repository.ReservationRepository;
import com.repository.UserRepository;
import com.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //GET REZ BY ID

    public Optional getReservation(Long reservationId) {
        System.out.println("service getReservation( ==>");
        Optional reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            return reservation;
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }

    public List<Reservation> getAllReservations() {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(userDetails.getUser().getId());

        List<Reservation> reservation = reservationRepository.findByUserId(userDetails.getUser().getId());

        if (reservation.isEmpty()) {
            throw new InformationNotFoundException("no reservations found for user id " + userDetails.getUser().getId() + ".");
        } else {
            return reservation;
        }

    }

    public Reservation createReservation(Reservation reservationObject) {
        System.out.println("service calling createReservation ==>");
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        Reservation reservation = reservationRepository.findByUserIdAndName(
                userDetails.getUser().getId(), reservationObject.getName());
        if (reservation != null) {
            throw new InformationExistException("reservation with name " + reservation.getName() + " already exists");
        } else {
            reservationObject.setUser(userDetails.getUser());
            return reservationRepository.save(reservationObject);
        }
    }
//UPDATE //not working yet
    public Reservation updateReservation(Long reservationId, Reservation reservationObject) {
        System.out.println("service calling updateReservation ==>");
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
                updateReservation.setDeparture_airport(reservationObject.getDeparture_airport());
                updateReservation.setArrival_airport(reservationObject.getArrival_airport());
                updateReservation.setAirline_name(reservationObject.getAirline_name());
                return reservationRepository.save(updateReservation );
            }
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }
//DELETE
    public Optional<Reservation> deleteReservation(Long reservationId) {
        System.out.println("service calling deleteReservation ==>");
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);

        if (((Optional<?>) reservation).isPresent()) {
            reservationRepository.deleteById(reservationId);
            return reservation;
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }

}