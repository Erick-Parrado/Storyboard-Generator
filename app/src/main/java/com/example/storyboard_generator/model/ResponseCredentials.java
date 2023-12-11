package com.example.storyboard_generator.model;

import java.util.ArrayList;

public class ResponseCredentials {
    private Error error;
    private Info info;
    private ArrayList<Credential> credentials;
    private String message;

    public void setCredentials(ArrayList<Credential> credentials) {
        this.credentials = credentials;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Credential> getCredentials() {
        return credentials;
    }

    public String getMessage() {
        return message;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }
}
