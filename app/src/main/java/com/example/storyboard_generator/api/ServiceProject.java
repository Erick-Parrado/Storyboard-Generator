package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.POST_PROJECT_URL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ServiceProject {
    @POST(POST_PROJECT_URL)
    public Call<ResponseObj> postProject(@Body ProjectApi projectApi, @Path("user_id") int user_id);
}
