package com.codeup.diningreviewapi.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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






}
