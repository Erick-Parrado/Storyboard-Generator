package com.example.storyboard_generator.api;

public class PlaneApi {
    //PLANES
    private  int plan_id;
    private int plan_number;

    private int plan_duration;
    private String plan_description;
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

    public void setPlan_id(int plan_id) {
        this.plan_id = plan_id;
    }

    public void setPlan_number(int plan_number) {
        this.plan_number = plan_number;
    }

    public void setPlan_duration(int plan_duration) {
        this.plan_duration = plan_duration;
    }

    public void setPlan_description(String plan_description) {
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

    public int getPlan_id() {
        return plan_id;
    }

    public int getPlan_number() {
        return plan_number;
    }

    public int getPlan_duration() {
        return plan_duration;
    }

    public String getPlan_description() {
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
