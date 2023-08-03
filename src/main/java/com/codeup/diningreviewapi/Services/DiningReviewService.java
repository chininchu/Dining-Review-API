package com.codeup.diningreviewapi.Services;

import com.codeup.diningreviewapi.enums.ReviewStatus;
import com.codeup.diningreviewapi.models.DiningReview;
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


}
