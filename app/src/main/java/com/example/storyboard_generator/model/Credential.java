package com.example.storyboard_generator.model;

public class Credential {
    private String us_identifier;
    private String us_key;
    private int user_id;

    public void setUs_identifier(String us_identifier) {
        this.us_identifier = us_identifier;
    }

    public void setUs_key(String us_key) {
        this.us_key = us_key;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUs_identifier() {
        return us_identifier;
    }

    public String getUs_key() {
        return us_key;
    }

    public int getUser_id() {
        return user_id;
    }

}
