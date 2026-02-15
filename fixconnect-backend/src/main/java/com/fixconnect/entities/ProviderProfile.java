package com.fixconnect.entities;

import jakarta.persistence.Entity;

@Entity
public class ProviderProfile {
    private String  skills;
    private String bio;
    private Boolean verified;
    private Double rating;
    private Integer completedJobs;
}
