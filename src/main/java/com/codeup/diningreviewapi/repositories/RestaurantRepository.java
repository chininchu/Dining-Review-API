package com.codeup.diningreviewapi.repositories;

import com.codeup.diningreviewapi.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    boolean existsByNameAndZipCode(String name, String zipCode);


    @Query("SELECT r FROM Restaurant r JOIN r.diningReviews dr WHERE r.zipCode = :zipCode AND dr.peanutScore IS NOT NULL GROUP BY r.id ORDER BY r.overallScore DESC")
    List<Restaurant> findRestaurantsByZipCodeWithPeanutScores(@Param("zipCode") String zipCode);

    @Query("SELECT r FROM Restaurant r JOIN r.diningReviews dr WHERE r.zipCode = :zipCode AND dr.eggScore IS NOT NULL GROUP BY r.id ORDER BY r.overallScore DESC")
    List<Restaurant> findRestaurantsByZipCodeWithEggScores(@Param("zipCode") String zipCode);

    @Query("SELECT r FROM Restaurant r JOIN r.diningReviews dr WHERE r.zipCode = :zipCode AND dr.dairyScore IS NOT NULL GROUP BY r.id ORDER BY r.overallScore DESC")
    List<Restaurant> findRestaurantsByZipCodeWithDairyScores(@Param("zipCode") String zipCode);


}
