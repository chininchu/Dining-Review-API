package com.codeup.diningreviewapi.Services;

import com.codeup.diningreviewapi.enums.ReviewStatus;
import com.codeup.diningreviewapi.models.DiningReview;
import com.codeup.diningreviewapi.models.Restaurant;
import com.codeup.diningreviewapi.repositories.DiningReviewRepository;
import com.codeup.diningreviewapi.repositories.DiningUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiningReviewService {

    private final DiningReviewRepository diningReviewRepository;


    @Autowired

    public DiningReviewService(DiningReviewRepository diningReviewRepository) {

        this.diningReviewRepository = diningReviewRepository;


    }

    public DiningReview submitDiningReview(DiningReview diningReview) {

        // Implement logic to handle user-submitted dining reviews
        // (Scenario: As a registered user, I want to submit a dining review)

        return diningReviewRepository.save(diningReview);

    }

    public List<DiningReview> getPendingDiningReviews() {

        // Implement logic to fetch all dining reviews that are pending approval
        // (Scenario: As an admin, I want to get the list of all dining reviews that are pending approval)
        return diningReviewRepository.findByStatus(ReviewStatus.PENDING);


    }

    public void approveOrRejectDiningReview(Long reviewId, boolean isApproved) {

        // Implement logic to approve or reject a given dining review
        // (Scenario: As an admin, I want to approve or reject a given dining review)

        DiningReview diningReview = diningReviewRepository.findById(reviewId).orElse(null);

        if (diningReview != null) {

            if (isApproved) {

                diningReview.setStatus(ReviewStatus.ACCEPTED);

            } else {

                diningReview.setStatus(ReviewStatus.REJECTED);
            }

            diningReviewRepository.save(diningReview);


        }


    }


    public List<DiningReview> getApprovedDiningReviewsForRestaurant(Restaurant restaurant) {

        // Implement logic to fetch all approved dining reviews for a given restaurant
        // (Scenario: To update a restaurant’s set of scores, fetch the set of all approved dining reviews belonging to this restaurant)
        return diningReviewRepository.findByRestaurantAndStatus(restaurant, ReviewStatus.ACCEPTED);


    }


}
