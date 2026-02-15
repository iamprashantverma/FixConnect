package com.fixconnect.entities;

import com.fixconnect.utils.RandomIdGen;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProviderProfile {

    private static final String PREFIX = "PROF_";

    @Id
    @Column(nullable = false, updatable = false)
    private String profileId;

    @PrePersist
    void generateId() {
        profileId = RandomIdGen.gen(PREFIX);
    }

    private String skills;
    private String bio;
    private Boolean verified;
    private Double rating;
    private Integer completedJobs;
}
