package com.codeup.diningreviewapi.repositories;

import com.codeup.diningreviewapi.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {


    // Query to fetch restaurants by zip code and sorted by overall score

    @Query("SELECT r FROM Restaurant  r " +
            "INNER JOIN r.diningReviews dr " +
            "INNER JOIN dr.diningUser du " +
            "WHERE du.zipcode = :zipCode " +
            "AND (dr.peanutScore IS NOT NULL OR dr.eggScore iS NOT NULL OR dr.dairyScore IS NOT NULL) " +
            "GROUP BY r.id " +
            "ORDER BY r.overallScore DESC ")
    List<Restaurant> findRestaurantsByZipCodeWithAllergyScores(String zipCode);

    // Query to check if a restaurant with the same name and zip code already exists

    boolean existsByNameAndDiningReviews_DiningUser_Zipcode(String name, String zipCode);


}
