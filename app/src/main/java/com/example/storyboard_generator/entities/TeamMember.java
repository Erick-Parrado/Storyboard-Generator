package com.example.storyboard_generator.entities;

import com.example.storyboard_generator.entities.User;
public class TeamMember extends User{

    private String rol;
    private int projectId;


    public TeamMember(int id, String name, String email, String password, String phone, String rol ){
        super(id,name,email,password,phone);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getProjectId() {
        return projectId;
    }
}
