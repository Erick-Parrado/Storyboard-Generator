package com.example.storyboard_generator.model;

import static com.example.storyboard_generator.api.ApiValues.NO_RESPONDED_EXCEPTION;
import static com.example.storyboard_generator.api.ApiValues.NO_RESPONSE_EXCEPTION;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.storyboard_generator.api.ServiceLogin;
import com.example.storyboard_generator.entities.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDAO extends DAO {

    public UserDAO(){
        super();
    }

    public void login(String email, String password,ResponseTaker responseTaker) throws Exception{
        //String password = md5(etPass.getText().toString());
        Loger loger = new Loger();
        loger.setUser_email(email);
        loger.setUser_pass(password);
        ServiceLogin service = retrofit.create(ServiceLogin.class);
        Call<ResponseObj> call = service.accessLogin(loger);
        calling(call,responseTaker);
        //Toast.makeText(view.getContext(), exception.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void calling(Call call,ResponseTaker responseTaker) throws Exception{
        Exception exceptionCall = new Exception();
        call.enqueue(new Callback<ResponseObj>() {
            @Override
            public void onResponse(Call<ResponseObj> call, Response<ResponseObj> response) {
                if(response.isSuccessful()){
                    ResponseObj body = response.body();
                    if(!isNullOrEmpty(body.getError())) {
                        Error error =body.getError();
                        DAO.exception= new Exception(error.getStatus());
                    }
                    if(!isNullOrEmpty(body.getInfo())){
                        Info info = body.getInfo();
                    }
                    responseTaker.takeResponse(body);
                }
                else{
                    DAO.exception = new Exception(NO_RESPONSE_EXCEPTION);
                }
            }
            @Override
            public void onFailure(Call<ResponseObj> call, Throwable t) {
                Log.i("response",t.getMessage());
                DAO.exception = new Exception(NO_RESPONDED_EXCEPTION);
            }
        });
        if(DAO.exception!=null){
            throw DAO.exception;
        }
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
