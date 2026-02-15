package com.fixconnect.entities;

import com.fixconnect.entities.enums.Status;
import jakarta.persistence.Entity;

@Entity
public class Bid {
    private String providerId;
    private Double price;
    private String estimatedTime;
    private String msg;
    private Status status;
}
