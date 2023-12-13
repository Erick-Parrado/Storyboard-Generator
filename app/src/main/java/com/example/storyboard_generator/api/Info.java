package com.example.storyboard_generator.api;

public class Info {
    private String status;
    private String message;

    private int count;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
