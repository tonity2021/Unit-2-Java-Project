package com.controller;

import com.exceptions.InformationExistException;
import com.exceptions.InformationNotFoundException;
import com.model.Reservation;
import com.model.UserProfile;
import com.repository.ReservationRepository;
import com.security.MyUserDetails;
import com.service.ProfileService;
import com.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/auth")

public class ProfileController {
    private ProfileService profileService;

    @Autowired
    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Autowired
    public void setReservationService(ReservationService reservationService) {
        this.profileService= profileService;
    }


    //create a user profile
    @PostMapping("/users/profile/")
    public UserProfile createProfile(@RequestBody UserProfile userProfileObject) {
        System.out.println("calling createProfile ==>");
        return profileService.createProfile(userProfileObject);
    }

}
