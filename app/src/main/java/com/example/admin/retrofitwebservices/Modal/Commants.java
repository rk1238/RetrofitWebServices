package com.example.admin.retrofitwebservices.Modal;

import com.google.gson.annotations.SerializedName;

public class Commants
{
    @SerializedName("id")
    private int id;
    @SerializedName("body")
    private String body;
    @SerializedName("postId")
    private String postId;

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getPostId() {
        return postId;
    }
}
