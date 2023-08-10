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

    @Query("SELECT r FROM Restaurant r " +
            "JOIN r.diningReviews dr " +
            "WHERE r.zipCode = :zipCode " +
            "AND (CASE WHEN :allergy = 'peanut' THEN dr.peanutScore IS NOT NULL " +
            "WHEN :allergy = 'egg' THEN dr.eggScore IS NOT NULL " +
            "WHEN :allergy = 'dairy' THEN dr.dairyScore IS NOT NULL " +
            "ELSE FALSE END) " +
            "GROUP BY r.id " +
            "ORDER BY r.overallScore DESC")
    List<Restaurant> findRestaurantsByZipCodeWithAllergyScores(@Param("zipCode") String zipCode, @Param("allergy") String allergy);


}
