package com.example.admin.retrofitwebservices.Modal;

import com.google.gson.annotations.SerializedName;

public class Posts
{
    @SerializedName("id")
    private  int id;
    @SerializedName("userId")
    private String userId;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;

    public int getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

}
