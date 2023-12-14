package com.example.storyboard_generator.api;

public class SceneApi {
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
}
