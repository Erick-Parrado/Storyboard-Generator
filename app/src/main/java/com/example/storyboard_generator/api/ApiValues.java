package com.example.storyboard_generator.api;

public interface ApiValues {
        String BASE_URL = "http://192.168.109.9/Storyboard-Generator-API/API/";

        //End Points
        //LOGIN
        String POST_LOGIN_URL = "login";
        //USERS
        String GET_USER_URL = "users/{user_id}";
        String POST_USER_URL = "users";

        String PUT_USER_URL = "users/{user_id}";
        String DELETE_USER_URL = "users/{user_id}";

        //PROJECT
        String GET_PROJECT_URL = "projects/{proj_id}";
        String POST_PROJECT_URL = "projects/{user_id}";
        String PUT_PROJECT_URL = "projects/{proj_id}";
        String PATCH_PROJECT_URL = "projects/{proj_id}/PIN";

        //TEAM_MEMBERS

        String GET_TEAM_USERS_URL = "teams/{proj_id}/users";
        String GET_TEAM_PROJECTS_URL = "teams/{user_id}/projects";
        String GET_TEAM_ROLES_URL = "teams/{role_id}/roles";
        String POST_TEAM_URL = "teams";
        String PUT_TEAM_URL = "teams";
        String DELETE_TEAM_URL = "teams";

        //SCENES
        String GET_SCENES_DAYTIMES_URL = "/scenes/{dayT_id}/daytimes";
        String GET_SCENES_SPACES_URL = "/scenes/{spac_id}/spaces";
        String GET_SCENES_URL = "/scenes/{scen_number}/{proj_id}";

        String POST_SCENES_URL = "/scenes/{proj_id}";

        String PUT_SCENES_URL = "/scenes/{scen_number}/{proj_id}";

        String DELETE_SCENES_URL = "/scenes/{scen_number}/{proj_id}";

        //PLANES
        
        String GET_PLAENES_MOVES_URL = "planes/{move_id}/moves";
        String GET_PLAENES_FRAMINGS_URL = "planes/{fram_id}/framings";
        String GET_PLAENES_SHOTS_URL = "planes/{shot_id}/shots";
        String GET_PLAENES_URL = "planes/{plan_number}/{scen_number}/{proj_id* ";
        String POST_PLAENES_URL = "planes/{scen_number}/{proj_id}";
        String PUT_PLAENES_URL = "planes/{plan_number}/{scen_number}/{proj_id*";
        String DELETE_PLAENES_URL = "planes/{plan_number}/{scen_number}/{proj_id*";

        //Exceptions
        String NO_RESPONSE_EXCEPTION = "734";
        String NO_RESPONDED_EXCEPTION = "827";
}
