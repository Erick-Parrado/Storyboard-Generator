package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.GET_USER_URL;

import com.example.storyboard_generator.model.Loger;
import com.example.storyboard_generator.model.ResponseCredentials;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceUsers {
    @GET(GET_USER_URL)
    public Call<ResponseCredentials> getUser(@Path("user_id") int user_id,@Body Loger login);
}
