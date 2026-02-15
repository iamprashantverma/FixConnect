package com.fixconnect.entities;

import com.fixconnect.utils.RandomIdGen;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Notification {

    private static final String PREFIX = "NOT_";

    @Id
    @Column(nullable = false, updatable = false)
    private String notificationId;

    @PrePersist
    void generateId() {
        if (notificationId == null) {
            notificationId = RandomIdGen.gen(PREFIX);
        }
    }

    private String userId;
    private String message;
    private Boolean read;
}
