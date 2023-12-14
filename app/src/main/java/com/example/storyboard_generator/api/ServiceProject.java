package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.DELETE_PLAENES_URL;
import static com.example.storyboard_generator.api.ApiValues.DELETE_PROJECT_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_PROJECT_URL;
import static com.example.storyboard_generator.api.ApiValues.PATCH_PROJECT_PIN_URL;
import static com.example.storyboard_generator.api.ApiValues.POST_PROJECT_URL;
import static com.example.storyboard_generator.api.ApiValues.PUT_PROJECT_URL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceProject {
    @GET(GET_PROJECT_URL)
    public Call<ResponseObj> getProject(@Path("proj_id") int proj_id);

    @POST(POST_PROJECT_URL)
    public Call<ResponseObj> postProject(@Body ProjectApi projectBoy, @Path("user_id") int user_id);

    @PUT(PUT_PROJECT_URL)
    public Call<ResponseObj> putProject(@Body ProjectApi projectBoy,@Path("proj_id") int proj_id);

    @DELETE(DELETE_PROJECT_URL)
    public Call<ResponseObj> deleteProject(@Body ProjectApi projectBoy,@Path("proj_id") int proj_id);
    @PATCH(PATCH_PROJECT_PIN_URL)
    public Call<ResponseObj> patchPINProject(@Body ProjectApi projectBoy,@Path("proj_id") int proj_id);
}
