package com.service;
import com.exceptions.InformationExistException;
import com.exceptions.InformationNotFoundException;
import com.model.Reservation;
import com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public void setReservationRepository(ReservationRepository  reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservation() {
        System.out.println("service calling getReservations ==>");
        return reservationRepository.findAll();
    }

    public Optional getReservation(Long reservationId) { //optional object
        System.out.println("service getReservation ==>");
        Optional reservation = reservationRepository.findById(reservationId);
        if (reservation.isPresent()) {
            return reservation;
        } else {
            throw new InformationNotFoundException("reservation with id " + reservationId + " not found");
        }
    }

    public Reservation createReservation(Reservation reservationObject) {
        System.out.println("service calling createReservation ==>");

        Reservation reservation = reservationRepository.findByName(reservationObject.getName());
        if (reservation != null) {
            throw new InformationExistException("reservation with name " + reservation.getName() + " already exists");
        } else {
            return reservationRepository.save(reservationObject);
        }
    }



}

