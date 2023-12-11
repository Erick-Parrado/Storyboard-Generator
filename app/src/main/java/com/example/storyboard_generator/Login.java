package com.example.storyboard_generator;

import static com.example.storyboard_generator.api.ApiValues.BASE_URL;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storyboard_generator.api.ServiceLogin;
import com.example.storyboard_generator.model.Connection;
import com.example.storyboard_generator.model.Credential;
import com.example.storyboard_generator.model.Error;
import com.example.storyboard_generator.model.Info;
import com.example.storyboard_generator.model.Loger;
import com.example.storyboard_generator.model.ResponseConnection;
import com.example.storyboard_generator.model.ResponseCredentials;
import com.example.storyboard_generator.remote.ClientRetrofit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Login extends AppCompatActivity {
    private Button btnLoginLogin;
    private Button btnRegisterLogin;

    private Retrofit retrofit;
    private EditText etEmail;
    private EditText etPass;

    private TextView tvError;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        validateConnection();
        begin();
    }


    private void begin(){
        this.btnLoginLogin = findViewById(R.id.btnLoginLogin);
        this.btnRegisterLogin = findViewById(R.id.btnRegisterLogin);
        this.etEmail = findViewById(R.id.etEmailLogin);
        this.etPass = findViewById(R.id.etPssLogin);
        btnLoginLogin.setOnClickListener(this::handleLogin);
        btnRegisterLogin.setOnClickListener(this::goToRegister);
        this.tvError = findViewById(R.id.tvError);
    }

    private void validateConnection(){
        retrofit = ClientRetrofit.getClient(BASE_URL);
        ServiceLogin serviceLogin = retrofit.create(ServiceLogin.class);
        Call<ResponseConnection> call = serviceLogin.confirmConnection();
        call.enqueue(new Callback<ResponseConnection>() {
            @Override
            public void onResponse(Call<ResponseConnection> call, Response<ResponseConnection> response) {
                if(response.isSuccessful()){
                    alert(":v");
                }
                else{
                    alert(":'v");
                }
            }

            @Override
            public void onFailure(Call<ResponseConnection> call, Throwable t) {
                alert(">:'v");
            }
        });
    }

    private void handleLogin(View view){
        if(!validEmail(etEmail.getText().toString()) && etPass.getText().length() <=3){
            alert("Error login");
        }
        else{
            //String password = md5(etPass.getText().toString());
            Loger loger = new Loger();
            loger.setUser_email(etEmail.getText().toString());
            loger.setUser_pass(etPass.getText().toString());
            retrofit = ClientRetrofit.getClient(BASE_URL);
            ServiceLogin service = retrofit.create(ServiceLogin.class);
            Call<ResponseCredentials> call = service.accessLogin(loger);
            call.enqueue(new Callback<ResponseCredentials>() {
                @Override
                public void onResponse(Call<ResponseCredentials> call, Response<ResponseCredentials> response) {
                    if(response.isSuccessful()){
                        alert(":v");
                        ResponseCredentials body = response.body();
                        if(!isNullOrEmpty(body.getError())) {
                            Error error =body.getError();
                            alert(error.getMessage());
                        }
                        if(!isNullOrEmpty(body.getInfo())){
                            Info info = body.getInfo();
                            alert(info.getMessage());
                        }
                        ArrayList<Credential> credentials = body.getCredentials();
                        if(!isNullOrEmpty(credentials)){
                            alert("Bien hecho ;D");
                            for(Credential c:credentials){
                                SharedPreferences SPCredentials = getSharedPreferences("CREDENTIALS", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = SPCredentials.edit();
                                editor.putString("key",c.getUs_key());
                                editor.putString("identifier",c.getUs_identifier());
                                editor.commit();
                            }
                            goToProject();
                        }
                        else{
                            alert("Cagaste 👻");
                        }
                    }
                    else{
                        alert("Cagaste 👻");
                    }
                }

                @Override
                public void onFailure(Call<ResponseCredentials> call, Throwable t) {

                    Log.i("response",t.getMessage());
                    tvError.setText(t.getMessage());
                    alert("Cagaste 💀");
                }
            });
        }
    }
    private void goToProject(){
        try{
            Intent goProjects = new Intent(getApplicationContext(), Projects.class);
            startActivity(goProjects);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    private void goToRegister(View view){
        try{
            Intent goProjects = new Intent(getApplicationContext(), Register.class);
            startActivity(goProjects);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    private boolean validEmail(String data){
        Pattern pattern =Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~\\-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        Matcher mather = pattern.matcher(data);
        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
            return true;
        }
        else {
            System.out.println("El email ingresado es inválido.");
        }
        return false;
    }


    private static boolean isNullOrEmpty(Object obj){
        if(obj==null)return true;
        if(obj instanceof String) return ((String)obj).trim().equals("") || ((String)obj).equalsIgnoreCase("NULL");
        if(obj instanceof Integer) return ((Integer)obj)==0;
        if(obj instanceof Long) return ((Long)obj).equals(new Long(0));
        if(obj instanceof Double) return ((Double)obj).equals(0.0);
        if(obj instanceof Collection) return (((Collection)obj).isEmpty());
        return false;
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



    private void alert(String mssg){
        Toast.makeText(this,mssg,Toast.LENGTH_LONG).show();
    }
}