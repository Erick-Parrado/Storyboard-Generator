package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.DELETE_TEAM_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_TEAM_PROJECTS_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_TEAM_ROLES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_TEAM_USERS_URL;
import static com.example.storyboard_generator.api.ApiValues.POST_TEAM_URL;
import static com.example.storyboard_generator.api.ApiValues.PUT_TEAM_URL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceTeam {
    @GET(GET_TEAM_USERS_URL)
    public Call<ResponseObj> getUsersTeam(@Path("proj_id") int proj_id);

    @GET(GET_TEAM_PROJECTS_URL)
    public Call<ResponseObj> getProjectsTeam(@Path("user_id") int user_id);

    @GET(GET_TEAM_ROLES_URL)
    public Call<ResponseObj> getRolesTeam(@Path("role_id") int role_id);

    @POST(POST_TEAM_URL)
    public Call<ResponseObj> postMemberTeam(@Body TeamApi teamBody);
    @PUT(PUT_TEAM_URL)
    public Call<ResponseObj> putRolTeam(@Body TeamApi teamBody);
    @POST(DELETE_TEAM_URL)
    public Call<ResponseObj> deleteMemberProject(@Body TeamApi teamBody);

}
