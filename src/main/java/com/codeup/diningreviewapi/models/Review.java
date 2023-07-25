package com.codeup.diningreviewapi.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reviews")
@Data

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName; // Who submitted (display name)

    @Lob

    private String commentary;


}
