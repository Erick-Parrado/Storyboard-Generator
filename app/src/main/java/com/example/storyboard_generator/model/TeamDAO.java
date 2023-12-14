package com.example.storyboard_generator.model;

import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.ServiceTeam;
import com.example.storyboard_generator.entities.Project;

import java.util.ArrayList;

import retrofit2.Call;

public class TeamDAO extends DAO{
    public TeamDAO(){super();}

    public void getProjects(int user_id, ResponseTaker responseTaker){
        ArrayList<Project> projects = new ArrayList<>();
        ServiceTeam service = retrofit.create(ServiceTeam.class);
        Call<ResponseObj> call = service.getProjectsTeam(user_id);
        calling(call,responseTaker);
    }
}
