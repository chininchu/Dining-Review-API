package com.codeup.diningreviewapi.controllers;

import com.codeup.diningreviewapi.Services.DiningReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dining-reviews")
public class DiningReviewController {

    private final DiningReviewService diningReviewService;

    @Autowired

    public DiningReviewController(DiningReviewService diningReviewService) {

        this.diningReviewService = diningReviewService;


    }


}
