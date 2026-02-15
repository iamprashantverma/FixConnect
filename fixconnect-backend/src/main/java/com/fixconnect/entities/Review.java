package com.fixconnect.entities;

import jakarta.persistence.Entity;

@Entity
public class Review {
    private Long providerId ;
    private String comment ;
    private Double rating ;
}
