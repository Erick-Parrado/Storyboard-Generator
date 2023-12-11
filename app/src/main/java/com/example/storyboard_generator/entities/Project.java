package com.example.storyboard_generator.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {

    private String id;
    private String title;
    private String description;
    private String pin;
    private String producer;
    private LocalDateTime updateDate;
    private ArrayList<TeamMember>teamMembers;
    private ArrayList<Scene> scenes;


    public Project(String id, String title, String description, String pin, String producer, String updateDate ){

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public ArrayList<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(ArrayList<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public ArrayList<Scene> getScenes() {
        return scenes;
    }

    public void setScenes(ArrayList<Scene> scenes) {
        this.scenes = scenes;
    }
}

