package com.codeup.diningreviewapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

@Entity
@Table(name = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName; // Who submitted (display name)


    private Integer peanutScore; // Optional peanut score (1-5)
    private Integer eggScore; // Optional egg score (1-5)
    private Integer dairyScore; // Optional dairy score (1-5)


    @Lob

    private String commentary;


    // Entity Relationships

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant; // The restaurant (represented by its Id)

    @ManyToOne
    @JoinColumn(name = "dining_user_id")
    private DiningUser diningUser;


}
