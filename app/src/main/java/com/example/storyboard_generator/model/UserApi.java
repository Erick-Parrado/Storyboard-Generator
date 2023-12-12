package com.example.storyboard_generator.model;

public class UserApi {
    private int user_id;
    private String user_name;
    private String user_lastName;
    private String user_pass;
    private String user_email;
    private String user_phone;

    public void setUser_email(String user_email){this.user_email = user_email;}
    public void setUser_id(int user_id){this.user_id = user_id;}
    public void setUser_name(String user_name) { this.user_name = user_name;}
    public void setUser_lastName(String user_lastName) {this.user_lastName = user_lastName;}
    public void setUser_pass(String user_pass) {this.user_pass = user_pass;}
    public void setUser_phone(String user_phone) {this.user_phone = user_phone;}

    public String getUser_email() {return user_email;}

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_lastName() {
        return user_lastName;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public String getUser_phone() {
        return user_phone;
    }
}
