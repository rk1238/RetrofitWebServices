package com.example.admin.retrofitwebservices.Modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataGetData {
    @SerializedName("posts")
    private List<PostsOf> postof;
    @SerializedName("comments")
    private List<Commants> commants;
    @SerializedName("profile")
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public List<PostsOf> getPostof() {
        return postof;
    }

    public List<Commants> getCommants() {
        return commants;
    }
}
