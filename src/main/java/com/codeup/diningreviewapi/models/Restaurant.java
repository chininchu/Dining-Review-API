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

    // Scores for individual categories
    private Double peanutScore;
    private Double eggScore;
    private Double dairyScore;

    // Overall score for the restaurant
    private Double overallScore;

    // Create Relationships

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<DiningReview> diningReviews;


}
