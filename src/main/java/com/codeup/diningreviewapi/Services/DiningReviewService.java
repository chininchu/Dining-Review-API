package com.codeup.diningreviewapi.Services;

import com.codeup.diningreviewapi.models.DiningReview;
import com.codeup.diningreviewapi.repositories.DiningReviewRepository;
import com.codeup.diningreviewapi.repositories.DiningUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
