package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.DELETE_SCENES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_SCENES_DAYTIMES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_SCENES_SPACES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_SCENES_URL;
import static com.example.storyboard_generator.api.ApiValues.POST_SCENES_URL;
import static com.example.storyboard_generator.api.ApiValues.PUT_PROJECT_URL;
import static com.example.storyboard_generator.api.ApiValues.PUT_SCENES_URL;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServiceScenes {
    @GET(GET_SCENES_URL)
    public Call<ResponseObj> getScene(@Path("scen_number") int scen_number,@Path("proj_id") int proj_id);

    @GET(GET_SCENES_DAYTIMES_URL)
    public Call<ResponseObj> getDayTimes(@Path("dayT_id") int dayT_id);

    @GET(GET_SCENES_SPACES_URL)
    public Call<ResponseObj> getSpaces(@Path("spac_id") int spac_id);

    @POST(POST_SCENES_URL)
    public Call<ResponseObj> getScene(@Path("proj_id") int proj_id,@Body SceneApi sceneBody);

    @PUT(PUT_SCENES_URL)
    public Call<ResponseObj> putScene(@Path("scen_number") int scen_number,@Path("proj_id") int proj_id, @Body SceneApi sceneBody);

    @GET(DELETE_SCENES_URL)
    public Call<ResponseObj> deleteScene(@Path("scen_number") int scen_number,@Path("proj_id") int proj_number);

}
