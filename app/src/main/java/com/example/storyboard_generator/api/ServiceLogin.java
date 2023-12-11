package com.example.storyboard_generator.api;

import com.example.storyboard_generator.model.Loger;
import com.example.storyboard_generator.model.ResponseCredentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ServiceLogin {
    public int test = 0;
    @POST("login")
    public Call<ResponseCredentials> accessLogin(@Body Loger login);
}
