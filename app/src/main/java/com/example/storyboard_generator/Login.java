package com.example.storyboard_generator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.layout.AlertActor;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.api.Credential;
import com.example.storyboard_generator.model.DAO;
import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.model.UserDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import retrofit2.Retrofit;

public class Login extends OurActivity {
    private Button btnLoginLogin;

    //private Retrofit retrofit;
    private EditText etEmail;
    private EditText etPass;

    private TextView tvError;

    private Integer intents;
    private Boolean justRegistered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intents = 0;
        justRegistered = false;
        begin();
        justRegistered();
    }

    public void justRegistered(){
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            justRegistered = (boolean) extras.get("justRegistered");
            if(justRegistered){
                snackBar("Registro exitoso, ahora inicia tu sesion ;D",false);
                Intent i= getIntent();
            }
        }
    }

    private void begin(){
        this.btnLoginLogin = findViewById(R.id.btnLoginLogin);
        this.etEmail = findViewById(R.id.etEmailLogin);
        this.etPass = findViewById(R.id.etPssLogin);
        //this.tvError = findViewById(R.id.tvError);
        btnLoginLogin.setOnClickListener(this::handleLogin);
        fields=new ArrayList<>(Arrays.asList(etEmail,etPass));
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
        AlertActor alertActor= new AlertActor() {
            @Override
            public void alertAction() {
                goToLayout(Register.class);
            }
        };
        if(intents>=3){
            snackBar("Tal vez no estas registrado intentalo:",false,"Registrarse",alertActor);
        }
        if(!validEmail(etEmail.getText().toString()) || !validPass(etPass.getText().toString())){
            if(intents<3){
                snackBar("Usuario o contraseña incorrectas",true);
                intents++;
            }
        }
        else{
            ResponseTaker responseTaker = new ResponseTaker() {
                @Override
                public void takeResponse(ResponseObj body) {
                    User user = new User();
                    ArrayList<Credential> credentials = body.getCredentials();
                    if(!DAO.isNullOrEmpty(credentials)){
                        for(Credential c:credentials){
                            user.setId(c.getUser_id());
                            user.setIdentifier(c.getUs_identifier());
                            user.setKey(c.getUs_key());
                        }
                        setLoginSP(user);
                        goToProject();
                        clearFields(fields);
                    }
                    else{
                        if(intents<3){
                            intents++;
                            snackBar("Usuario o contraseña incorrectas",false);
                        }
                    }
                }

                @Override
                public void manageMessage(String status,String mssg) {

                    switch (status){
                        case "209":
                            intents++;
                            snackBar("Usuario o contraseña incorrectas",false);
                            break;
                        default:
                            tinyAlert("Error"+status,true);
                    }
                }
            };
            if(etPass.isActivated() || etEmail.isActivated()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
                }

            }
            UserDAO userDAO = new UserDAO();
            String email = etEmail.getText().toString();
            String password = etPass.getText().toString();
            userDAO.login(email,password,responseTaker);
        }
    }

    private boolean validPass(String pass) {
        Pattern pattern =Pattern.compile("^(?=.*[a-zñ]+)(?=.*[A-ZÑ]+)(?=.*[0-9]+)(?=.*[!@#$%^&:;+*(){}\\-\\]\\[\\/<>]+)[a-zñA-ZÑ0-9!@#$%^&:;+*(){}\\-\\]\\[\\/<>]{8,}$");
        Matcher mather = pattern.matcher(pass);

        if (mather.find() == true) {
            System.out.println("Contreseña incompleta.");
            return true;
        }
        else{
            System.out.println("Contraseña correcta.");
            return false;
        }
    }

    private void goToProject(){
        goToLayout(Projects.class);
    }

    private boolean validEmail(String data){
        Pattern pattern =Pattern.compile("^([a-zA-Z0-9!\\\"#$%&'()*,_.\\-\\/]{3,})@([a-z]{5,})\\.([a-z]{2,3})(\\.[a-z]{2,3})?$");
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
}