package com.example.b9000v0.Schema;

import java.util.List;

public class User {
    private String id;
    private String profile_Image_URL;
    private String username;
    private String password_hash;
    private String email;
    private String bio;
    private String full_name;

    private List<String> following;

    //TODO ADD PROFILE PICC
    public User(String id, String username, String password_hash, String email, String bio, String full_name, List<String> following) {
        this.id = id;
        this.profile_Image_URL = profile_Image_URL;
        this.username = username;
        this.password_hash = password_hash;
        this.email = email;
        this.bio = bio;
        this.full_name = full_name;
        this.following = following;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile_Image_URL() {
        return profile_Image_URL;
    }

    public void setProfile_Image_URL(String profile_Image_URL) {
        this.profile_Image_URL = profile_Image_URL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        this.following = following;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
