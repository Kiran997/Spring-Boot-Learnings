package com.project.CrudOperationsTask.Controller;


import java.time.LocalDateTime;

public class UserResponse {
    private int userId;
    private String fullName;
    private String mobNum;
    private String panNum;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobNum() {
        return mobNum;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    public String getPanNum() {
        return panNum;
    }

    public void setPanNum(String panNum) {
        this.panNum = panNum;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


// Constructor, getters, and setters

    @Override
    public String toString() {
        return "UserResponse{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", mobNum='" + mobNum + '\'' +
                ", panNum='" + panNum + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", active=" + active +
                '}';
    }

    public UserResponse(int userId, String fullName, String mobNum, String panNum, LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
        this.userId = userId;
        this.fullName = fullName;
        this.mobNum = mobNum;
        this.panNum = panNum;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }
}