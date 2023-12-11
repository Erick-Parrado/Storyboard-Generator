package com.example.storyboard_generator.entities;

public class Plane {

    private int id;
    private int number;
    private int duration;
    private String description;
    private String shot;
    private String framming;
    private String move;
    private String image;


    public void Plane(int duration, String description, String shot, String framming, String move){

    }

    public  void addImageFromCamera(String image){

    }

    public  void addImageFromStorage(String image){

    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShot() {
        return shot;
    }

    public void setShot(String shot) {
        this.shot = shot;
    }

    public String getFramming() {
        return framming;
    }

    public void setFramming(String framming) {
        this.framming = framming;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
