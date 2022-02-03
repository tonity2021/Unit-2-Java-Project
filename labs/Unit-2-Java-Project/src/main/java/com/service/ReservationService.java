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

    public List<Reservation> getAllReservations() {

        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(userDetails.getUser().getId());

        List<Reservation> reservation = reservationRepository.findByUserId(userDetails.getUser().getId());

        if (reservation.isEmpty()) {
            throw new InformationNotFoundException("no reservation found for user id " + userDetails.getUser().getId() + " not found");
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



}