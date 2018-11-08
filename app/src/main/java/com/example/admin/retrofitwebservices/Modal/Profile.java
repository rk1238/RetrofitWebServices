package com.example.admin.retrofitwebservices.Modal;

import com.google.gson.annotations.SerializedName;

public class Profile {
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }
}
