package com.example.storyboard_generator.api;

import com.example.storyboard_generator.api.Credential;
import com.example.storyboard_generator.api.Error;
import com.example.storyboard_generator.api.Info;

import java.util.ArrayList;

public class ResponseObj {
    //Templates
    private Error error;
    private Info info;

    //Login
    private ArrayList<Credential> credentials;

    //Users

    public void setCredentials(ArrayList<Credential> credentials) {
        this.credentials = credentials;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public ArrayList<Credential> getCredentials() {
        return credentials;
    }


    public void setInfo(Info info) {
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }
}
