package com.fixconnect.entities;

import com.fixconnect.entities.enums.Priority;
import com.fixconnect.entities.enums.Status;
import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class ServiceRequest {

    private String title;
    private String description;
    private String imageUrl;
    private Double latitude;
    private Double longitude;
    private Priority urgency;
    private Status status;
    private Date createdAt;

}
