package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.GET_USER_URL;
import static com.example.storyboard_generator.api.ApiValues.POST_USER_URL;

import com.example.storyboard_generator.model.ResponseObj;
import com.example.storyboard_generator.model.UserApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceUsers {
    @GET(GET_USER_URL)
    public Call<ResponseObj> getUser(@Path("user_id") int user_id);

    @POST(POST_USER_URL)
    public Call<ResponseObj> postUser(@Body UserApi user);
}
