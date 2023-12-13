package com.example.storyboard_generator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.layout.ExtrasSetter;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.layout.AlertActor;
import com.example.storyboard_generator.model.ResponseObj;
import com.example.storyboard_generator.model.ResponseTaker;
import com.example.storyboard_generator.model.UserDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends OurActivity {
    private EditText etName;
    private EditText etPhone;
    private EditText etEmail;
    private EditText etPass;
    private EditText etPassConf;
    private Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        begin();
    }

    private void begin(){
        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPssRegister);
        etPassConf=findViewById(R.id.etPssConf);
        btRegister = findViewById(R.id.btRegister);
        btRegister.setOnClickListener(this::handleRegister);
    }

    private void handleRegister(View view){
        ExtrasSetter extrasSetter = new ExtrasSetter() {
            @Override
            public void setExtras(Intent i) {
                i.putExtra("justRegistered",true);
            }
        };
        ResponseTaker responseTaker = new ResponseTaker() {
            @Override
            public void takeResponse(ResponseObj body) {
                goToLayout(Login.class,extrasSetter);
            }
        };
        AlertActor alertActor = new AlertActor() {
            @Override
            public void alertAction() {
                goToLayout(Login.class);
            }
        };
        try{
            User user = takeUser();
            tinyAlert(user.getEmail(),true);
            UserDAO userDAO = new UserDAO();
            userDAO.register(user,responseTaker);
        }catch (Exception e){
            switch (e.getMessage()){
                case "209":
                    snackBar("Ya estas registrado,intenta>> ",false,"Iniciar sesion",alertActor);
                    break;
                default:
                    snackBar(e.getMessage(),true);
            }
        }
    }

    private User takeUser() throws Exception{
        String name = etName.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        String passConf = etPassConf.getText().toString();
        ArrayList<String> fields = new ArrayList<String>(Arrays.asList(name,phone,email,pass,passConf));
        validVoids(fields);
        validEmail(email);
        validPass(pass,passConf);
        validUnVoids(name);
        validPhone(phone);
        User user = new User(name,email,pass,phone);
        return user;
    }

    private  void validUnVoids(String name) throws Exception{
        if(name=="")throw new Exception("No pueden haber campos vacios");
    }
    private  void validPhone(String phone) throws  Exception{
        Pattern pattern =Pattern.compile("^\\d{10}$");
        Matcher mather = pattern.matcher(phone);
        if (mather.find() == true) {
            System.out.println("Numero telefonico correcto.");
        }
        else{
            System.out.println("Numero telefonico incorrecto.");
            throw  new Exception("Numero telefonico incorrecto.");
        }

    }
    private void validPass(String pass,String passConf) throws Exception{
        Pattern pattern =Pattern.compile("^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*[0-9]+)(?=.*[!@#$%^&:;+*(){}\\-\\]\\[\\/<>]+)[a-zA-Z0-9!@#$%^&:;+*(){}\\-\\]\\[\\/<>]{8,}$");
        Matcher mather = pattern.matcher(pass);

        if (mather.find() != true) {
            System.out.println("Contreseña incompleta.");
            throw  new Exception("La contraseña debe tener 8 caracteres,1 minuscula, 1 mayuscula, 1 numero y 1 caracter especial.");
        }
        else if(!pass.equals(passConf)){
            System.out.println("Contraseñas no coinciden.");
            throw  new Exception("Las contraseñas no coinciden.");
        }
        else{
            System.out.println("Contraseña correcta");
        }
    }

    private void validEmail(String email) throws Exception{
        Pattern pattern =Pattern.compile("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~\\-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$");
        Matcher mather = pattern.matcher(email);
        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
        }
        else {
            System.out.println("El email ingresado no es válido.");
            throw  new Exception("El email ingresado no es inválido.");
        }
    }
}