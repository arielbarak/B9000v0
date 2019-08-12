package com.example.b9000v0.Schema;

import java.util.List;

public class Post {
    private String id;
    private String creator_user_id;
    private String image_URL;
    private String caption;
    private enum category{
        MoviesandTV, Education, Dank
    }

    private List<String> liked_by_user_list;
    private List<String> comments_list;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator_user_id() {
        return creator_user_id;
    }

    public void setCreator_user_id(String creator_user_id) {
        this.creator_user_id = creator_user_id;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<String> getLiked_by_user_list() {
        return liked_by_user_list;
    }

    public void setLiked_by_user_list(List<String> liked_by_user_list) {
        this.liked_by_user_list = liked_by_user_list;
    }

    public List<String> getComments_list() {
        return comments_list;
    }

    public void setComments_list(List<String> comments_list) {
        this.comments_list = comments_list;
    }
}
