package com.example.storyboard_generator.model;

import java.util.ArrayList;

public class ResponseCredentials {
    private ArrayList<Credential> credentials;
    private String message;

    public ResponseCredentials(ArrayList<Credential> credentials) {
    }

    public void setCredentials(ArrayList<Credential> credentials) {
        this.credentials = credentials;
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
}
