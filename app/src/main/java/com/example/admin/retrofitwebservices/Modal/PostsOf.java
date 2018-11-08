package com.example.admin.retrofitwebservices.Modal;

import com.google.gson.annotations.SerializedName;

public class PostsOf {
    @SerializedName("id")
    private  int id;
    @SerializedName("title")
    private String title;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
