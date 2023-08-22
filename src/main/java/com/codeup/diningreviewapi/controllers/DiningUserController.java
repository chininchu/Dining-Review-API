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

    @PostMapping("/create")
    public ResponseEntity<DiningUser> createUser(@RequestBody DiningUser diningUser) {

        DiningUser createdUser = diningUserService.createUser(diningUser);

        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);


    }

    @PutMapping("/{id}")

    public ResponseEntity<DiningUser> updateUser(@PathVariable Long id, @RequestBody DiningUser diningUser) {
/// Set the ID from the URL path to the user object
        diningUser.setId(id);

        DiningUser updateUser = diningUserService.updateUser(diningUser);


        return new ResponseEntity<>(updateUser, HttpStatus.OK);


    }

    @GetMapping("/{displayName}")

    public ResponseEntity<DiningUser> getUserByDisplayName(@PathVariable String displayName) {

        DiningUser diningUser = diningUserService.fetchUserByDisplayName(displayName);

        if (diningUser != null) {

            return new ResponseEntity<>(diningUser, HttpStatus.OK
            );
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);


        }


    }


}
