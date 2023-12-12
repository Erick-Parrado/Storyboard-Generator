package com.example.storyboard_generator.api;

public interface ApiValues {
        String BASE_URL = "http:/192.168.5.106/Storyboard-Generator-API/API/";

        //End Points

        //LOGIN
        String POST_LOGIN_URL = "login";
        //USERS
        String GET_USER_URL = "users/{user_id}";
        String POST_USER_URL = "users";

        //Exceptions
        String NO_RESPONSE_EXCEPTION = "734";
        String NO_RESPONDED_EXCEPTION = "827";
}
