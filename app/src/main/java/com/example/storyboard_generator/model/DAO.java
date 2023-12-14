package com.example.storyboard_generator.model;

import static com.example.storyboard_generator.api.ApiValues.BASE_URL;
import static com.example.storyboard_generator.api.ApiValues.NO_RESPONDED_EXCEPTION;
import static com.example.storyboard_generator.api.ApiValues.NO_RESPONSE_EXCEPTION;

import android.util.Log;

import com.example.storyboard_generator.api.Error;
import com.example.storyboard_generator.api.Info;
import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.Info;
import com.example.storyboard_generator.remote.ClientRetrofit;

import java.util.Collection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DAO {
    protected Retrofit retrofit;

    public DAO(){
        retrofit = ClientRetrofit.getClient(BASE_URL);
    }
    protected void calling(Call call, ResponseTaker responseTaker){

        call.enqueue(new Callback<ResponseObj>() {
            @Override
            public void onResponse(Call<ResponseObj> call, Response<ResponseObj> response) {
                if(response.isSuccessful()){
                    ResponseObj body = response.body();
                    if(!isNullOrEmpty(body.getError())) {
                        Error error =body.getError();
                        responseTaker.manageMessage(error.getStatus()+"",error.getMessage());
                        return;
                    }
                    if(!isNullOrEmpty(body.getInfo())){
                        Info info = body.getInfo();
                        responseTaker.manageMessage(info.getStatus(),info.getCount()+"");
                        responseTaker.takeResponse(body,info);
                    }
                }
                else{
                    responseTaker.manageMessage(NO_RESPONSE_EXCEPTION,"No hubo respuesta");
                }
            }
            @Override
            public void onFailure(Call<ResponseObj> call, Throwable t) {
                Log.i("onFailure",t.getMessage());
                responseTaker.manageMessage(NO_RESPONDED_EXCEPTION,"No responderr");
            }
        });
    }

//    protected void calling(Call call) throws Exception{
//        call.enqueue(new Callback<ResponseObj>() {
//            @Override
//            public void onResponse(Call<ResponseObj> call, Response<ResponseObj> response) {
//                if(response.isSuccessful()){
//                    ResponseObj body = response.body();
//                    if(!isNullOrEmpty(body.getError())) {
//                        Error error =body.getError();
//                        DAO.exception= new Exception(error.getStatus());
//                    }
//                    if(!isNullOrEmpty(body.getInfo())){
//                        Info info = body.getInfo();
//                        DAO.exception= new Exception(info.getStatus());
//                    }
//                }
//                else{
//                    DAO.exception = new Exception(NO_RESPONSE_EXCEPTION);
//                }
//            }
//            @Override
//            public void onFailure(Call<ResponseObj> call, Throwable t) {
//                Log.i("onFailure",t.getmanageMessage());
//                DAO.exception = new Exception(NO_RESPONDED_EXCEPTION);
//            }
//        });
//        if(DAO.exception!=null){
//            throw DAO.exception;
//        }
//    }
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
