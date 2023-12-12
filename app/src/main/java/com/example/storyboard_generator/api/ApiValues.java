package com.example.storyboard_generator.api;

public interface ApiValues {
        String BASE_URL = "http:/110.57.30.208/Storyboard-Generator-API/API/";

        //End Points

        //LOGIN
        String POST_LOGIN_URL = "login";
        //USERS
        String GET_USER_URL = "users/{user_id}";
        String POST_USER_URL = "users";

        //PROJECT
        String POST_PROJECT_URL = "project/{user_id}";

        //Exceptions
        String NO_RESPONSE_EXCEPTION = "734";
        String NO_RESPONDED_EXCEPTION = "827";
}
