package com.example.storyboard_generator.api;

public class Result{
    //USERS
    private int user_id;
    private String user_name;
    private String user_phone;
    private String user_email;
    private String user_pass;

    //PROJECTS
    private int proj_id;
    private String proj_tittle;
    private String proj_producer;
    private String proj_dateUpdate;
    private String proj_pin;
    private String proj_description;
    private String proj_image;

    //SCENES

    private int scen_id;
    private int scen_number;
    private int scen_duration;
    private String scen_place;

    //DAY TIMES
    private int dayT_id;
    private String dayT_name;
    private  String dayT_abr;

    //SPACES
    private int spac_id;
    private String spac_name;
    private String spac_abr;

    //PLANES
    private  int plan_id;
    private int plan_number;
    private int plan_description;
    private String plan_image;

    //FRAMINGS
    private int fram_id;
    private String fram_name;
    private String fram_abr;

    //SHOTS
    private int shot_id;
    private String shot_name;
    //MOVES
    private int move_id;
    private String move_name;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
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

    public void setProj_dateUpdate(String proj_dateUpdate) {
        this.proj_dateUpdate = proj_dateUpdate;
    }

    public void setProj_pin(String proj_pin) {
        this.proj_pin = proj_pin;
    }

    public void setProj_description(String proj_description) {
        this.proj_description = proj_description;
    }

    public void setProj_image(String proj_image) {
        this.proj_image = proj_image;
    }

    public void setScen_id(int scen_id) {
        this.scen_id = scen_id;
    }

    public void setScen_number(int scen_number) {
        this.scen_number = scen_number;
    }

    public void setScen_duration(int scen_duration) {
        this.scen_duration = scen_duration;
    }

    public void setScen_place(String scen_place) {
        this.scen_place = scen_place;
    }

    public void setDayT_id(int dayT_id) {
        this.dayT_id = dayT_id;
    }

    public void setDayT_name(String dayT_name) {
        this.dayT_name = dayT_name;
    }

    public void setDayT_abr(String dayT_abr) {
        this.dayT_abr = dayT_abr;
    }

    public void setSpac_id(int spac_id) {
        this.spac_id = spac_id;
    }

    public void setSpac_name(String spac_name) {
        this.spac_name = spac_name;
    }

    public void setSpac_abr(String spac_abr) {
        this.spac_abr = spac_abr;
    }

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public void setPlan_number(int plan_number) {
        this.plan_number = plan_number;
    }

    public void setPlan_description(int plan_description) {
        this.plan_description = plan_description;
    }

    public void setPlan_image(String plan_image) {
        this.plan_image = plan_image;
    }

    public void setFram_id(int fram_id) {
        this.fram_id = fram_id;
    }

    public void setFram_name(String fram_name) {
        this.fram_name = fram_name;
    }

    public void setFram_abr(String fram_abr) {
        this.fram_abr = fram_abr;
    }

    public void setShot_id(int shot_id) {
        this.shot_id = shot_id;
    }

    public void setShot_name(String shot_name) {
        this.shot_name = shot_name;
    }

    public void setMove_id(int move_id) {
        this.move_id = move_id;
    }

    public void setMove_name(String move_name) {
        this.move_name = move_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public String getUser_email() {
        return user_email;
    }

    public String getUser_pass() {
        return user_pass;
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

    public String getProj_dateUpdate() {
        return proj_dateUpdate;
    }

    public String getProj_pin() {
        return proj_pin;
    }

    public String getProj_description() {
        return proj_description;
    }

    public String getProj_image() {
        return proj_image;
    }

    public int getScen_id() {
        return scen_id;
    }

    public int getScen_number() {
        return scen_number;
    }

    public int getScen_duration() {
        return scen_duration;
    }

    public String getScen_place() {
        return scen_place;
    }

    public int getDayT_id() {
        return dayT_id;
    }

    public String getDayT_name() {
        return dayT_name;
    }

    public String getDayT_abr() {
        return dayT_abr;
    }

    public int getSpac_id() {
        return spac_id;
    }

    public String getSpac_name() {
        return spac_name;
    }

    public String getSpac_abr() {
        return spac_abr;
    }

    public int getPlan_id() {
        return plan_id;
    }

    public int getPlan_number() {
        return plan_number;
    }

    public int getPlan_description() {
        return plan_description;
    }

    public String getPlan_image() {
        return plan_image;
    }

    public int getFram_id() {
        return fram_id;
    }

    public String getFram_name() {
        return fram_name;
    }

    public String getFram_abr() {
        return fram_abr;
    }

    public int getShot_id() {
        return shot_id;
    }

    public String getShot_name() {
        return shot_name;
    }

    public int getMove_id() {
        return move_id;
    }

    public String getMove_name() {
        return move_name;
    }
}
