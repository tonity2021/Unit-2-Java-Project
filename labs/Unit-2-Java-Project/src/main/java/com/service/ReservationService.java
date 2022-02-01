package com.service;
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
    public void setReservationRepository(ReservationRepository  categoryRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservations() {
        System.out.println("service calling getReservations ==>");
        return reservationRepository.findAll();
    }
}

