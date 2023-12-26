package com.codeup.diningreviewapi.controllers;

import com.codeup.diningreviewapi.Services.DiningReviewService;
import com.codeup.diningreviewapi.models.DiningReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dining-reviews")
public class DiningReviewController {

    //Test with SSH Key

    private final DiningReviewService diningReviewService;

    @Autowired

    public DiningReviewController(DiningReviewService diningReviewService) {

        this.diningReviewService = diningReviewService;


    }

    @PostMapping("/submit")
    public DiningReview submitDiningReview(@RequestBody DiningReview diningReview) {


        return diningReviewService.submitDiningReview(diningReview);


    }

    @GetMapping("/admin/pending")
    public List<DiningReview> getPendingReviews() {

        return diningReviewService.getPendingDiningReviews();
    }

    @PutMapping("/admin/{reviewId}")

    public void approveOrRejectDiningReview(@PathVariable Long reviewId, @RequestParam boolean isApproved) {

        diningReviewService.approveOrRejectDiningReview(reviewId, isApproved);


    }


}
