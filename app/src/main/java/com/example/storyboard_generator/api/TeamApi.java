package com.example.storyboard_generator.api;

public class TeamApi {
    private int team_id;
    private int proj_id;
    private int user_id;
    private int role_id;

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public void setProj_id(int proj_id) {
        this.proj_id = proj_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public int getProj_id() {
        return proj_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getRole_id() {
        return role_id;
    }
}
