package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.DELETE_PROJECT_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_USER_URL;
import static com.example.storyboard_generator.api.ApiValues.POST_USER_URL;
import static com.example.storyboard_generator.api.ApiValues.PUT_PROJECT_URL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceUsers {
    @GET(GET_USER_URL)
    public Call<ResponseObj> getUser(@Path("user_id") int user_id);

    @POST(POST_USER_URL)
    public Call<ResponseObj> postUser(@Body UserApi userBody);

    @PUT(PUT_PROJECT_URL)
    public Call<ResponseObj> putUser(@Path("user_id") int user_id,@Body UserApi userBody);

    @DELETE(DELETE_PROJECT_URL)
    public Call<ResponseObj> deleteUser(@Path("user_id") int user_id);

}
