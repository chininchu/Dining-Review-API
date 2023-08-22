package com.codeup.diningreviewapi.controllers;

import com.codeup.diningreviewapi.Services.RestaurantService;
import com.codeup.diningreviewapi.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;


    @Autowired

    public RestaurantController(RestaurantService restaurantService) {

        this.restaurantService = restaurantService;


    }

    @PostMapping("/create")
    public ResponseEntity<?> createRestaurant(@RequestBody Restaurant restaurant) {

        Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);

        return ResponseEntity.ok(createdRestaurant);


    }


    @GetMapping("/{id}")

    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {

        Restaurant restaurant = restaurantService.getRestaurantById(id);

        if (restaurant != null) {
            return ResponseEntity.ok(restaurant);


        } else {

            return ResponseEntity.notFound().build();
        }


    }

    @GetMapping("/search")

    public ResponseEntity<List<Restaurant>> searchRestaurantsByZipCodeAndAllergyScores(@RequestParam String zipCode, @RequestParam String allergy) {

        List<Restaurant> restaurants = restaurantService.getRestaurantsByZipCodeAndAllergyScores(zipCode, allergy);

        if (!restaurants.isEmpty()) {

            return ResponseEntity.ok(restaurants);


        } else {

            return ResponseEntity.noContent().build();
        }


    }


}
