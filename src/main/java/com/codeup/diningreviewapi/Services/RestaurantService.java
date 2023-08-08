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


}
