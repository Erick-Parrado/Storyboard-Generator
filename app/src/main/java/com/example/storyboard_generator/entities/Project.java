package com.example.storyboard_generator.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {

    private int id;
    private String title;
    private String description;
    private String pin;
    private String producer;
    private String updateDate;
    private ArrayList<Scene> scenes;

    private String image;

    public Project() {
    }

    public Project(int id, String title, String description, String pin, String producer, String updateDate, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pin = pin;
        this.producer = producer;
        this.updateDate = updateDate;
        this.image = image;
    }

    public Project(int id, String title, String description, String pin, String producer, LocalDateTime updateDateteamMembers, ArrayList<Scene> scenes, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pin = pin;
        this.producer = producer;
        this.updateDate = updateDate;
        this.scenes = scenes;
        this.image = image;
    }

    public void  addScene(Scene scene){


    }

    public void  generateAccessPin (){

    }

    public void  deleteMember(int userId){

    }

    public void  changeMemberRol(int userId, int rollId){

    }

    public void  notifyChanges(){

    }

    public void  deleteProject(){

    }

    public void  deleteEscene(){

    }

    private Integer scenesCount(){
        return null;
    }

    public String getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

