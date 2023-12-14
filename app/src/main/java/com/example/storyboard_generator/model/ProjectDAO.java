package com.example.storyboard_generator.model;

import com.example.storyboard_generator.api.ProjectApi;
import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.Info;
import com.example.storyboard_generator.api.ServiceProject;
import com.example.storyboard_generator.entities.Project;

import retrofit2.Call;

public class ProjectDAO extends DAO{

    public ProjectDAO (){
        super();
    }

    public void createProject(int user_id, Project project, ResponseTaker responseTaker){
        ProjectApi projectBody = new ProjectApi();
        projectBody.setProj_tittle(project.getTitle());
        projectBody.setProj_description(project.getDescription());
        projectBody.setProj_image(project.getImage());
        projectBody.setProj_producer(project.getProducer());
        ServiceProject servive = retrofit.create(ServiceProject.class);
        Call<ResponseObj> call = servive.postProject(projectBody,user_id);
        calling(call,responseTaker);
    }

    public void getProject(int proj_id,ResponseTaker responseTaker){
        ServiceProject servive = retrofit.create(ServiceProject.class);
        Call<ResponseObj> call = servive.getProject(proj_id);
        calling(call,responseTaker);
    }
}
