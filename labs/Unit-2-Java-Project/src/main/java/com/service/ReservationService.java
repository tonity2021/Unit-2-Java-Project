package com.service;

import com.exceptions.InformationExistException;
import com.exceptions.InformationNotFoundException;
import com.model.Reservation;
import com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservation() {
        System.out.println("service calling getReservations ==>");
        return reservationRepository.findAll();
    }

    //get reservations
    public Optional getReservation(Long reservationId) { //optional object which may contain null and non-null values
        System.out.println("service getReservation ==>");
        Optional reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            return reservation;
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }

    //create reservation
    public Reservation createReservation(Reservation reservationObject) {
        System.out.println("service calling createReservation ==>");

        Reservation reservation = reservationRepository.findByName(reservationObject.getName());
        if (reservation != null) {
            throw new InformationExistException("reservation with flight " + reservation.getName() + " already exists");
        } else {
            return reservationRepository.save(reservationObject);
        }
    }

    //update reservation
    public Reservation updateReservation(Long reservationId, Reservation reservationObject) {
        System.out.println("service calling updateReservation ==>");
        Optional<Reservation> reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            if (reservationObject.getName().equals(reservation.get().getName())) {
                System.out.println("Same");
                throw new InformationExistException("reservation" + reservation.get().getName() + " already exists");
            } else {
                Reservation updateReservation = reservationRepository.findById(reservationId).get();
                updateReservation.setName(reservationObject.getName());
                updateReservation.setDeparture_city(reservationObject.getDeparture_city());
                updateReservation.setDestination(reservationObject.getDestination());
                updateReservation.setDeparture_time(reservationObject.getDeparture_time());
                updateReservation.setArrival_time(reservationObject.getArrival_time());
                updateReservation.setDeparture_airport(reservationObject.getDeparture_airport());
                updateReservation.setArrival_airport(reservationObject.getArrival_airport());
                updateReservation.setAirline_name(reservationObject.getAirline_name());
                updateReservation.setBoarding_gate(reservationObject.getBoarding_gate());
                return reservationRepository.save(updateReservation);
            }
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }

    //delete reservation
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


