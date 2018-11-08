package com.example.admin.retrofitwebservices.Modal;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonPlaceHolder {

    @GET("typicode/demo/db")
    Call<DataGetData> dataGetData();
    @GET("posts")
    Call<List<Posts>> getPosts(@Query("id ") String i);
}
