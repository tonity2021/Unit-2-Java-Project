package com.repository;

import com.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

//interface class that holds method for saving,deleting and finding reservations
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Reservation findByName(String reservationName);
}
