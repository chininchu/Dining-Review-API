package com.codeup.diningreviewapi.controllers;

import com.codeup.diningreviewapi.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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







}
