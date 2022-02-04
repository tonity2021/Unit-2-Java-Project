package com.service;

import com.exceptions.InformationExistException;
import com.model.UserProfile;
import com.repository.UserProfileRepository;
import com.repository.UserRepository;
import com.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    private UserProfileRepository userProfileRepository;

    @Autowired
    public void setUserProfileRepository(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create a new user profile
    public UserProfile createProfile(UserProfile userProfileObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("service calling createProfile ==>");

        UserProfile userProfile = userProfileRepository.findByUserId(userDetails.getUser().getId());
        if (userProfile != null) {
            throw new InformationExistException("profile with id " + userProfile.getId() + " already exists");
        } else {
            userProfileObject.setUser(userDetails.getUser());
            return userProfileRepository.save(userProfileObject);
        }
    }
}
