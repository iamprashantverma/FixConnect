package com.fixconnect.entities;

import com.fixconnect.utils.RandomIdGen;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {

    private static final String PREFIX = "REV_";

    @Id
    @Column(nullable = false, updatable = false)
    private String reviewId;

    @PrePersist
    void generateId() {
        reviewId = RandomIdGen.gen(PREFIX);
    }

    private String providerId;
    private String comment;
    private Double rating;

}
