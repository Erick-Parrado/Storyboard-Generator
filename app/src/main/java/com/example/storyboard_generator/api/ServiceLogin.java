package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.POST_LOGIN_URL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceLogin {
    public int test = 0;
    @POST(POST_LOGIN_URL)
    public Call<ResponseObj> accessLogin(@Body LogerApi login);
}
