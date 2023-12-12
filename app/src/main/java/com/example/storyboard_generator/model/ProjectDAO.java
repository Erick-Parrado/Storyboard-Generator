package com.example.storyboard_generator.model;

import com.example.storyboard_generator.api.ServiceProject;

import retrofit2.Call;

public class ProjectDAO extends DAO{
    private int id;
    private String tittle;
    private String producer;
    private String description;
    private String dateUpdate;
    private String pin;
    private String image;

    public ProjectDAO (){
        super();
    }

    public void createProject(int user_id,ResponseTaker responseTaker) throws Exception{
        ProjectApi projectBody = new ProjectApi();
        projectBody.setProj_tittle(this.tittle);
        projectBody.setProj_description(this.description);
        projectBody.setProj_image(this.image);
        projectBody.setProj_producer(this.producer);
        ServiceProject servive = retrofit.create(ServiceProject.class);
        Call<ResponseObj> call = servive.postProject(projectBody,user_id);
        calling(call,responseTaker);
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getProducer() {
        return producer;
    }

    public String getDescription() {
        return description;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public String getPin() {
        return pin;
    }

    public String getImage() {
        return image;
    }
}
