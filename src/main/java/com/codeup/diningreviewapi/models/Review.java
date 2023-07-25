package com.codeup.diningreviewapi.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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



    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant; // The restaurant (represented by its Id)

    private Integer peanutScore; // Optional peanut score (1-5)
    private Integer eggScore; // Optional egg score (1-5)
    private Integer dairyScore; // Optional dairy score (1-5)


    @Lob

    private String commentary;


}
