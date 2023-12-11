package com.example.storyboard_generator.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Scene {
    private Integer id;
    private Integer number;
    private Integer duration;
    private String place;
    private String dayTime;
    private String space;

    private ArrayList<Plane> planes;


    public void Scene(String duration, String place, String space1){

    }

    public void deletePlane(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDuration() {
        return null;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }
}
