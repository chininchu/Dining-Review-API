package com.codeup.diningreviewapi.controllers;

import com.codeup.diningreviewapi.Services.DiningReviewService;
import com.codeup.diningreviewapi.models.DiningReview;
import com.codeup.diningreviewapi.models.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dining-reviews")
public class DiningReviewController {

    private final DiningReviewService diningReviewService;

    @Autowired

    public DiningReviewController(DiningReviewService diningReviewService) {

        this.diningReviewService = diningReviewService;


    }

    @PostMapping
    public DiningReview submitDiningReview(@RequestBody DiningReview diningReview) {

        return diningReviewService.submitDiningReview(diningReview);


    }

    @GetMapping("/pending")
    public List<DiningReview> getPendingReviews() {

        return diningReviewService.getPendingDiningReviews();
    }

    @PutMapping("/{reviewId}")

    public void approveOrRejectDiningReview(@PathVariable Long reviewId, @RequestParam boolean isApproved) {

        diningReviewService.approveOrRejectDiningReview(reviewId, isApproved);


    }

    // Unable to create this method at the moment since the restaurantService class does not exist.

//    @GetMapping("/restaurant/{restaurantId}/approved")
//    public List<DiningReview> getApprovedDiningReviewsForRestaurant(@PathVariable Long restaurantId){
//
//        // Fetch the Restaurant entity based on the restaurantId and pass it to the service method
//
//
//
//
//
//
//    }


}
