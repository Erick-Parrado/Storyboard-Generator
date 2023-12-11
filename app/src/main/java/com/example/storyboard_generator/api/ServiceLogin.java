package com.example.storyboard_generator.api;

import com.example.storyboard_generator.model.Connection;
import com.example.storyboard_generator.model.Loger;
import com.example.storyboard_generator.model.ResponseConnection;
import com.example.storyboard_generator.model.ResponseCredentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceLogin {
    @POST("login")
    public Call<ResponseCredentials> accessLogin(@Body Loger login);

    @POST("API")
    public Call<ResponseConnection> confirmConnection();

}
