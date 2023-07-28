package com.codeup.diningreviewapi.models;


import com.codeup.diningreviewapi.enums.ReviewStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dining_reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DiningReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName; // Who submitted (display name)


    private Integer peanutScore; // Optional peanut score (1-5)
    private Integer eggScore; // Optional egg score (1-5)
    private Integer dairyScore; // Optional dairy score (1-5)


    @Lob

    private String commentary;

    private ReviewStatus status;


    // Entity Relationships

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant; // The restaurant (represented by its Id)

    @ManyToOne
    @JoinColumn(name = "dining_user_id")
    private DiningUser diningUser;


}
