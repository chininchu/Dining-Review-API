package com.codeup.diningreviewapi.controllers;

import com.codeup.diningreviewapi.Services.RestaurantService;
import com.codeup.diningreviewapi.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;


    @Autowired

    public RestaurantController(RestaurantService restaurantService) {

        this.restaurantService = restaurantService;


    }

    @PostMapping
    public ResponseEntity<?> createRestaurant(@RequestBody Restaurant restaurant) {

        try {

            Restaurant createdREstaurant = restaurantService.createRestaurant(restaurant);

            return new ResponseEntity<>(createdREstaurant, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(e.getMessage());


        }


    }





}
