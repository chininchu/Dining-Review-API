package com.codeup.diningreviewapi.Services;


import com.codeup.diningreviewapi.models.DiningUser;
import com.codeup.diningreviewapi.repositories.DiningUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiningUserService {
    private final DiningUserRepository diningUserRepository;

    @Autowired
    public DiningUserService(DiningUserRepository diningUserRepository) {

        this.diningUserRepository = diningUserRepository;


    }

    public DiningUser createUser(DiningUser diningUser) {

        // Implement logic to check if the display name is unique before saving the user
        // (Scenario: As an unregistered user, I want to create my user profile using a unique display name)
        return diningUserRepository.save(diningUser);


    }

    public DiningUser updateUser(DiningUser diningUser) {

        // Implement logic to prevent modification of the unique display name
        // (Scenario: As a registered user, I want to update my user profile. I cannot modify my unique display name)
        return diningUserRepository.save(diningUser);


    }

    public DiningUser fetchUserByDisplayName(String displayName) {

        // Implement logic to fetch user profile by display name
        // (Scenario: As an application experience, I want to fetch the user profile belonging to a given display name)

        return diningUserRepository.findByDisplayName(displayName);


    }

    public boolean doesUserExistByDisplayName(String displayName) {

        // Implement logic to check if a user exists based on the given display name
        // (Scenario: As part of the backend process that validates a user-submitted dining review,
        // I want to verify that the user exists, based on the user display name associated with the dining review)

        return diningUserRepository.existsByDisplayName(displayName);


    }


}



