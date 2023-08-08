package com.codeup.diningreviewapi.Services;

import com.codeup.diningreviewapi.models.Restaurant;
import com.codeup.diningreviewapi.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;


    @Autowired

    public RestaurantService(RestaurantRepository restaurantRepository) {

        this.restaurantRepository = restaurantRepository;


    }

    public Restaurant createRestaurant(Restaurant restaurant) {

        // Check if a restaurant with the same name and zip code already exists

        if (restaurantRepository.existsByNameAndDiningReviews_DiningUser_Zipcode(restaurant.getName(), restaurant.getZipCode())) {

            throw new IllegalArgumentException("A restaurant with the same name and zip code already exists.");
        }

        return restaurantRepository.save(restaurant);


    }


}
