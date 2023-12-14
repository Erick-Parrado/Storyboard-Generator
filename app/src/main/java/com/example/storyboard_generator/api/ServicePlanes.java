package com.example.storyboard_generator.api;

import static com.example.storyboard_generator.api.ApiValues.DELETE_SCENES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_PLANES_FRAMINGS_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_PLANES_MOVES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_PLANES_SHOTS_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_PLANES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_SCENES_DAYTIMES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_SCENES_SPACES_URL;
import static com.example.storyboard_generator.api.ApiValues.GET_SCENES_URL;
import static com.example.storyboard_generator.api.ApiValues.POST_PLANES_URL;
import static com.example.storyboard_generator.api.ApiValues.POST_SCENES_URL;
import static com.example.storyboard_generator.api.ApiValues.PUT_SCENES_URL;

import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.SceneApi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ServicePlanes{
    @GET(GET_PLANES_URL)
    public Call<ResponseObj> getPlane(@Path("plan_number") int plan_number,@Path("scen_number") int scen_number, @Path("proj_id") int proj_id);

    @GET(GET_PLANES_MOVES_URL)
    public Call<ResponseObj> getMoves(@Path("move_id") int move_id);

    @GET(GET_PLANES_SHOTS_URL)
    public Call<ResponseObj> getShots(@Path("shot_id") int shot_id);

    @GET(GET_PLANES_FRAMINGS_URL)
    public Call<ResponseObj> getFramings(@Path("fram_id") int fram_id);

    @POST(POST_PLANES_URL)
    public Call<ResponseObj> postPlane(@Path("proj_id") int proj_id,@Path("scen_number") int scen_number,@Body PlaneApi planeBody);

    @PUT(PUT_SCENES_URL)
    public Call<ResponseObj> putScene(@Path("plan_id") int plan_id,@Path("scen_number") int scen_number,@Path("proj_number") int proj_number, @Body SceneApi sceneBody);

    @GET(DELETE_SCENES_URL)
    public Call<ResponseObj> deleteScene(@Path("plan_id") int plan_id,@Path("scen_number") int scen_number,@Path("proj_id") int proj_number);

}