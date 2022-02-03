package com.repository;

import com.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//interface class that holds method for saving,deleting and finding reservations
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


        Reservation findByName(String categoryName);

  List<Reservation> findByUserId(Long userId);
        Reservation findByUserIdAndName(Long userId, String name);
        Reservation findByIdAndUserId(Long CategoryId, Long UserId);

    }









//    Reservation findByName(String reservationName);

//    Reservation findById(Long reservationId, Long id);


//    List<Reservation> findByUserId(Long userId); //implemented reservation list and methods to follow//omitted
//List<Reservation> findByReservationId(Long ReservationId); //implemented reservation list and methods to follow

//    Reservation findByUserIdAndName(Long userId, String name);
//    Reservation findByIdAndUserId(Long ReservationId, Long UserId);


