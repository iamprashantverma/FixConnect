package com.fixconnect.entities;

import com.fixconnect.entities.enums.Status;
import com.fixconnect.utils.RandomIdGen;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Bid {

    private static final String PREFIX = "BID_";

    @Id
    private String bidId;

    @PrePersist
    void generateId() {
        this.bidId = RandomIdGen.gen(PREFIX);
    }

    private String providerId;
    private Double price;
    private String estimatedTime;
    private String msg;

    @Enumerated(EnumType.STRING)
    private Status status;
}
