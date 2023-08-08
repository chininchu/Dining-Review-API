package com.codeup.diningreviewapi.Services;

import com.codeup.diningreviewapi.models.DiningUser;
import com.codeup.diningreviewapi.models.Restaurant;
import com.codeup.diningreviewapi.repositories.DiningReviewRepository;
import com.codeup.diningreviewapi.repositories.DiningUserRepository;
import com.codeup.diningreviewapi.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;


    @Autowired

    public RestaurantService(RestaurantRepository restaurantRepository) {

        this.restaurantRepository = restaurantRepository;


    }

    public Restaurant createRestaurant(Restaurant restaurant, DiningUser diningUser) {

        // Check if a restaurant with the same name and zip code already exists

        if (restaurantRepository.existsByNameAndDiningReviews_DiningUser_Zipcode(restaurant.getName(), diningUser.getZipcode())) {

            throw new IllegalArgumentException("A restaurant with the same name and zip code already exists.");
        }

        return restaurantRepository.save(restaurant);


    }

    public Restaurant getRestaurantById(Long id) {

        return restaurantRepository.findById(id).orElse(null);


    }

    public List<Restaurant> getRestaurantsByZipCodeAndAllergyScores(String zipCode) {
        return restaurantRepository.findRestaurantsByZipCodeWithAllergyScores(zipCode);


    }


}
