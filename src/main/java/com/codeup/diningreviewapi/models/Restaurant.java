package com.codeup.diningreviewapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "restaurants")


public class Restaurant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "zip_code")
    private String zipCode;

    // Scores for individual categories
    private Double peanutScore;
    private Double eggScore;
    private Double dairyScore;

    // Overall score for the restaurant
    private Double overallScore;

    // Create Relationships

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<DiningReview> diningReviews;

    // Method to calculate the overall score based on individual category scores

    public void calculateOverallScore() {

        int numOfCategories = 0;
        double totalScore = 0;

        if (peanutScore != null) {
            totalScore += peanutScore;
            numOfCategories++;
        }

        if (eggScore != null) {
            totalScore += eggScore;
            numOfCategories++;
        }

        if (dairyScore != null) {
            totalScore += dairyScore;
            numOfCategories++;
        }

        if (numOfCategories > 0) {
            overallScore = totalScore / numOfCategories;
        } else {
            overallScore = null; // If no scores are submitted, overallScore is null
        }


    }


}
