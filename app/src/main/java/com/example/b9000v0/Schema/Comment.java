package com.example.b9000v0.Schema;

import java.util.Date;

public class Comment {
    private String id;
    private String content;

    private String user_Id;
    private String post_Id;

    private Date actionTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser_Id() {
        return user_Id;
    }

    public void setUserId(String user_Id) {
        this.user_Id = user_Id;
    }

    public String getPost_Id() {
        return post_Id;
    }

    public void setPost_Id(String postId) {
        this.post_Id = postId;
    }

    public Date getActionTime() {
        return actionTime;
    }

    public void setActionTime(Date actionTime) {
        this.actionTime = actionTime;
    }
}

