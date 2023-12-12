package com.example.storyboard_generator.model;

import static com.example.storyboard_generator.api.ApiValues.BASE_URL;

import com.example.storyboard_generator.remote.ClientRetrofit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import retrofit2.Retrofit;

public class DAO {
    protected Retrofit retrofit;
    public static Exception exception;

    public DAO(){
        retrofit = ClientRetrofit.getClient(BASE_URL);
    }

   static public boolean isNullOrEmpty(Object obj){
        if(obj==null)return true;
        if(obj instanceof String) return ((String)obj).trim().equals("") || ((String)obj).equalsIgnoreCase("NULL");
        if(obj instanceof Integer) return ((Integer)obj)==0;
        if(obj instanceof Long) return ((Long)obj).equals(new Long(0));
        if(obj instanceof Double) return ((Double)obj).equals(0.0);
        if(obj instanceof Collection) return (((Collection)obj).isEmpty());
        return false;
    }
}
