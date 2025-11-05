package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "referral")
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "from_profile_id", nullable = false)
    private RegistrationForm fromProfile;

    @ManyToOne
    @JoinColumn(name = "to_profile_id", nullable = false)
    private RegistrationForm toProfile;

    @Column(nullable = false)
    private String fromProfileStatus; // "Accepted", "Rejected", "Pending"

    @Column(nullable = false)
    private String toProfileStatus; // "Accepted", "Rejected", "Pending"

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = true)
    private String thistootherprofile;

    @Column(nullable = true)
    private String othertothisprofile;

    @Column(nullable = true)
    private String bothconnections;

    // Default constructor
    public Referral() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RegistrationForm getFromProfile() {
        return fromProfile;
    }

    public void setFromProfile(RegistrationForm fromProfile) {
        this.fromProfile = fromProfile;
    }

    public RegistrationForm getToProfile() {
        return toProfile;
    }

    public void setToProfile(RegistrationForm toProfile) {
        this.toProfile = toProfile;
    }

    public String getFromProfileStatus() {
        return fromProfileStatus;
    }

    public void setFromProfileStatus(String fromProfileStatus) {
        this.fromProfileStatus = fromProfileStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public String getToProfileStatus() {
        return toProfileStatus;
    }

    public void setToProfileStatus(String toProfileStatus) {
        this.toProfileStatus = toProfileStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getThistootherprofile() {
        return thistootherprofile;
    }

    public void setThistootherprofile(String thistootherprofile) {
        this.thistootherprofile = thistootherprofile;
        this.updatedAt = LocalDateTime.now();
    }

    public String getOthertothisprofile() {
        return othertothisprofile;
    }

    public void setOthertothisprofile(String othertothisprofile) {
        this.othertothisprofile = othertothisprofile;
        this.updatedAt = LocalDateTime.now();
    }

    public String getBothconnections() {
        return bothconnections;
    }

    public void setBothconnections(String bothconnections) {
        this.bothconnections = bothconnections;
        this.updatedAt = LocalDateTime.now();
    }
}
