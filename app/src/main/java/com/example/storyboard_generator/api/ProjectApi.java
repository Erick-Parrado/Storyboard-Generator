package com.example.storyboard_generator.api;

public class ProjectApi {
    private int proj_id;
    private String proj_tittle;
    private String proj_producer;
    private String proj_description;
    private String proj_dateUpdate;
    private String proj_pin;

    private String proj_image;

    public void setProj_image(String proj_image) {
        this.proj_image = proj_image;
    }

    public void setProj_id(int proj_id) {
        this.proj_id = proj_id;
    }

    public void setProj_tittle(String proj_tittle) {
        this.proj_tittle = proj_tittle;
    }

    public void setProj_producer(String proj_producer) {
        this.proj_producer = proj_producer;
    }

    public void setProj_description(String proj_description) {
        this.proj_description = proj_description;
    }

    public void setProj_dateUpdate(String proj_dateUpdate) {
        this.proj_dateUpdate = proj_dateUpdate;
    }

    public void setProj_pin(String proj_pin) {
        this.proj_pin = proj_pin;
    }

    public int getProj_id() {

        return proj_id;
    }

    public String getProj_tittle() {
        return proj_tittle;
    }

    public String getProj_producer() {
        return proj_producer;
    }

    public String getProj_description() {
        return proj_description;
    }

    public String getProj_dateUpdate() {
        return proj_dateUpdate;
    }

    public String getProj_pin() {
        return proj_pin;
    }

    public String getProj_image() {return proj_image;}
}
