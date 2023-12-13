package com.example.storyboard_generator.model;

import static com.example.storyboard_generator.api.ApiValues.BASE_URL;
import static com.example.storyboard_generator.api.ApiValues.NO_RESPONDED_EXCEPTION;
import static com.example.storyboard_generator.api.ApiValues.NO_RESPONSE_EXCEPTION;

import android.util.Log;

import com.example.storyboard_generator.remote.ClientRetrofit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DAO {
    protected Retrofit retrofit;
    public static Exception exception;

    public DAO(){
        retrofit = ClientRetrofit.getClient(BASE_URL);
    }
    protected void calling(Call call, ResponseTaker responseTaker) throws Exception{

        call.enqueue(new Callback<ResponseObj>() {
            @Override
            public void onResponse(Call<ResponseObj> call, Response<ResponseObj> response) {
                if(response.isSuccessful()){
                    DAO.exception =null;
                    ResponseObj body = response.body();
                    if(!isNullOrEmpty(body.getError())) {
                        Error error =body.getError();
                        DAO.exception= new Exception(error.getStatus());
                    }
                    if(!isNullOrEmpty(body.getInfo())){
                        Info info = body.getInfo();
                        //DAO.exception= new Exception(info.getStatus());
                    }
                    if( DAO.exception==null){
                        responseTaker.takeResponse(body);
                    }
                }
                else{
                    DAO.exception = new Exception(NO_RESPONSE_EXCEPTION);
                }
            }
            @Override
            public void onFailure(Call<ResponseObj> call, Throwable t) {
                Log.i("onFailure",t.getMessage());
                DAO.exception = new Exception(NO_RESPONDED_EXCEPTION);
            }
        });
        if(DAO.exception!=null){
            throw DAO.exception;
        }
    }

    protected void calling(Call call) throws Exception{
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
                        DAO.exception= new Exception(info.getStatus());
                    }
                }
                else{
                    DAO.exception = new Exception(NO_RESPONSE_EXCEPTION);
                }
            }
            @Override
            public void onFailure(Call<ResponseObj> call, Throwable t) {
                Log.i("onFailure",t.getMessage());
                DAO.exception = new Exception(NO_RESPONDED_EXCEPTION);
            }
        });
        if(DAO.exception!=null){
            throw DAO.exception;
        }
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
