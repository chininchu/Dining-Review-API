package com.codeup.diningreviewapi.repositories;

import com.codeup.diningreviewapi.enums.ReviewStatus;
import com.codeup.diningreviewapi.models.DiningReview;
import com.codeup.diningreviewapi.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiningReviewRepository extends JpaRepository<DiningReview, Long> {

    List<DiningReview> findByStatus(ReviewStatus status);

    List<DiningReview> findByRestaurantAndStatus(Restaurant restaurant, ReviewStatus status);



}


