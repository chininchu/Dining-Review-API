package com.codeup.diningreviewapi.controllers;


import com.codeup.diningreviewapi.Services.DiningUserService;
import com.codeup.diningreviewapi.models.DiningUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class DiningUserController {

    private final DiningUserService diningUserService;

    @Autowired
    public DiningUserController(DiningUserService diningUserService) {

        this.diningUserService = diningUserService;


    }

    @PostMapping
    public ResponseEntity<DiningUser> createUser(@RequestBody DiningUser diningUser) {

        DiningUser createdUser = diningUserService.createUser(diningUser);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);


    }


}
