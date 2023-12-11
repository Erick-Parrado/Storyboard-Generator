package com.example.storyboard_generator.model;

import static com.example.storyboard_generator.api.ApiValues.BASE_URL;
import static com.example.storyboard_generator.api.ApiValues.NO_RESPONDED_EXCEPTION;
import static com.example.storyboard_generator.api.ApiValues.NO_RESPONSE_EXCEPTION;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.storyboard_generator.api.ServiceLogin;
import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.remote.ClientRetrofit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserDAO extends DAO {

    public UserDAO(){
        super();
    }

    public User login(String email, String password) throws Exception{
        User user= new User();
        //String password = md5(etPass.getText().toString());
        Loger loger = new Loger();
        loger.setUser_email(email);
        loger.setUser_pass(password);
        ServiceLogin service = retrofit.create(ServiceLogin.class);
        Call<ResponseCredentials> call = service.accessLogin(loger);
        call.enqueue(new Callback<ResponseCredentials>() {
            @Override
            public void onResponse(Call<ResponseCredentials> call, Response<ResponseCredentials> response) {
                if(response.isSuccessful()){
                    ResponseCredentials body = response.body();
                    if(!isNullOrEmpty(body.getError())) {
                        Error error =body.getError();
                        exception = new Exception(error.getStatus());
                    }
                    if(!isNullOrEmpty(body.getInfo())){
                        Info info = body.getInfo();
                    }
                    ArrayList<Credential> credentials = body.getCredentials();
                    if(!isNullOrEmpty(credentials)){
                        for(Credential c:credentials){
                            user.setId(c.getUser_id());
                            user.setIdentifier(c.getUs_identifier());
                            user.setKey(c.getUs_key());
                        }
                    }
                }
                else{
                    exception = new Exception(NO_RESPONSE_EXCEPTION);
                }
            }

            @Override
            public void onFailure(Call<ResponseCredentials> call, Throwable t) {
                Log.i("response",t.getMessage());
                exception = new Exception(NO_RESPONDED_EXCEPTION);
            }
        });
        if(isNullOrEmpty(exception)){
        }
        if(!isNullOrEmpty(exception)){
            throw exception;
        }
        return user;
    }

    private static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2) h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
