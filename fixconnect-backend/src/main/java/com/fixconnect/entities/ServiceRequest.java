package com.fixconnect.entities;

import com.fixconnect.entities.enums.Priority;
import com.fixconnect.entities.enums.Status;
import com.fixconnect.utils.RandomIdGen;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ServiceRequest {

    private static final String PREFIX = "REQ_";

    @Id
    @Column(nullable = false, updatable = false)
    private String requestId;

    @PrePersist
    void generateId() {
        requestId = RandomIdGen.gen(PREFIX);
        createdAt = new Date();
    }

    private String title;
    private String description;
    private String imageUrl;
    private Double latitude;
    private Double longitude;

    @Enumerated(EnumType.STRING)
    private Priority urgency;

    @Enumerated(EnumType.STRING)
    private Status status;
    private Date createdAt;

}
