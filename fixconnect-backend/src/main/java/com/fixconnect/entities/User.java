package com.fixconnect.entities;

import com.fixconnect.entities.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import  com.fixconnect.utils.RandomIdGen;
@Entity(name = "users")
@Data
public class User {
    private static final String PREFIX = "USER_";
    @Id
    private  String userId;

    @PrePersist
    void generateId(){
        this.userId = RandomIdGen.gen(PREFIX);
    }

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,unique = true,length = 100)
    private String email;

    @Column(nullable = false,length = 100)
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private Boolean isVerified;

    @Column(nullable = false)
    private String address;

    @Column(nullable = true)
    private String profileImageUrl;

    private Double averageRating;

    private  Integer totalReviews ;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    private LocalDateTime lastLoginAt;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

}
