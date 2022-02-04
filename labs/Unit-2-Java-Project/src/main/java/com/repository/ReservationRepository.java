package com.repository;

import com.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//interface class that holds reservation list and methods
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    Reservation findByName(String reservationName);

    List<Reservation> findByUserId(Long userId);

    Reservation findByUserIdAndName(Long userId, String name);

    Reservation findByIdAndUserId(Long ReservationId, Long UserId);

}



