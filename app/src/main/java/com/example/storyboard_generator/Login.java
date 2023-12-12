package com.example.storyboard_generator;

import static com.example.storyboard_generator.api.ApiValues.BASE_URL;

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
import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.model.Credential;
import com.example.storyboard_generator.model.DAO;
import com.example.storyboard_generator.model.Error;
import com.example.storyboard_generator.model.Info;
import com.example.storyboard_generator.model.Loger;
import com.example.storyboard_generator.model.ResponseObj;
import com.example.storyboard_generator.model.ResponseTaker;
import com.example.storyboard_generator.model.UserDAO;
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
        begin();
    }


    private void begin(){
        this.btnLoginLogin = findViewById(R.id.btnLoginLogin);
        this.btnRegisterLogin = findViewById(R.id.btnRegisterLogin);
        this.etEmail = findViewById(R.id.etEmailLogin);
        this.etPass = findViewById(R.id.etPssLogin);
        this.tvError = findViewById(R.id.tvError);
        btnLoginLogin.setOnClickListener(this::handleLogin);
        btnRegisterLogin.setOnClickListener(this::goToRegister);
    }

    private void setLoginSP(User user){
        SharedPreferences.Editor editor;
        SharedPreferences SPCredentials = getSharedPreferences("CREDENTIALS", Context.MODE_PRIVATE);
        editor = SPCredentials.edit();
        editor.putString("key",user.getKey());
        editor.putString("identifier",user.getIdentifier());
        editor.commit();
        SharedPreferences SPUser = getSharedPreferences("USER", Context.MODE_PRIVATE);
        editor = SPUser.edit();
        editor.putInt("user_id",user.getId());
        editor.commit();
    }

    private void handleLogin(View view){
        if(!validEmail(etEmail.getText().toString()) && etPass.getText().length() <=3){
            alert("Error login");
        }
        else{
            ResponseTaker responseTaker = new ResponseTaker() {
                @Override
                public void takeResponse(ResponseObj body) {
                    User user = new User();
                    ArrayList<Credential> credentials = body.getCredentials();
                    alert(DAO.isNullOrEmpty(credentials)+"");
                    if(!DAO.isNullOrEmpty(credentials)){
                        for(Credential c:credentials){
                            user.setId(c.getUser_id());
                            user.setIdentifier(c.getUs_identifier());
                            user.setKey(c.getUs_key());
                        }
                        setLoginSP(user);
                        goToProject();
                    }
                    else{
                        alert(":P");
                    }
                }
            };
            UserDAO userDAO = new UserDAO();
            String email = etEmail.getText().toString();
            String password = etPass.getText().toString();
            try{
                userDAO.login(email,password,responseTaker);
            }
            catch (Exception e){
                Log.i("Error",e.getMessage());
            }

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

    private void alert(String mssg){
        Toast.makeText(this,mssg,Toast.LENGTH_LONG).show();
    }
}