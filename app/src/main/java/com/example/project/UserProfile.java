package com.example.project;

public class UserProfile {
    private String id;
    private String userId;
    private String username;
    private int totalScore;
    private String profilePictureUrl;

    // Constructor
    public UserProfile(String id, String username, String profilePictureUrl) {
        this.id = id;
        this.username = username;
        this.totalScore = 0; // กำหนดค่าเริ่มต้นเป็น 0
        this.profilePictureUrl = (profilePictureUrl != null) ? profilePictureUrl : "";
    }

    // Method เพิ่มคะแนน
    public void addScore(int score) {
        if (score > 0) {
            this.totalScore += score;
        }
    }

    // --- Getters & Setters ---
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getTotalScore() { return totalScore; }
    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }

    public String getProfilePictureUrl() { return profilePictureUrl; }
    public void setProfilePictureUrl(String profilePictureUrl) { this.profilePictureUrl = profilePictureUrl; }
}