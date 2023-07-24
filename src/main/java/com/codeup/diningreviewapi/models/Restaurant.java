package com.codeup.diningreviewapi.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Table(name = "restaurants")
@Data


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


}
