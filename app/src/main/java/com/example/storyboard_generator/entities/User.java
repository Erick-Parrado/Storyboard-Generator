package com.example.storyboard_generator.entities;

import static com.example.storyboard_generator.api.ApiValues.BASE_URL;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.storyboard_generator.api.ServiceLogin;
import com.example.storyboard_generator.model.Credential;
import com.example.storyboard_generator.model.Error;
import com.example.storyboard_generator.model.Info;
import com.example.storyboard_generator.model.ResponseCredentials;
import com.example.storyboard_generator.remote.ClientRetrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class User {

    protected int id;
    protected String name;
    protected String email;
    protected String password;
    protected String phone;
    private String identifier;
    private String key;

    public User(){}
    public User(int id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    static public void register(int id, String name, String email, String password, String phone){

    }

    private boolean accessProject(int projectId){
        return false;
    }


    ////////////////////SETTER/////////////////////
    public void setId(int id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setPassword(String password) {this.password = password;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setIdentifier(String identifier) {this.identifier = identifier;}
    public void setKey(String key) {this.key = key;}
    //////////////////////GETTERS//////////////////
    public int getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}
    public String getPhone() {return phone;}
    public String getIdentifier() {return identifier;}
    public String getKey() {return key;}
}

