package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.Result;
import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.layout.AlertActor;
import com.example.storyboard_generator.layout.ExtrasSetter;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.model.DAO;
import com.example.storyboard_generator.model.UserDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditUserForm extends OurActivity {

    private ImageView profilePhotoForm;
    private ImageButton btnAddPhotoForm;
    private EditText etUserName;
    private EditText etUserEmail;
    private EditText etUserPhone;
    private EditText etUserPss;
    private Button btnConfirmProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user_form);
        begin();

    }

    @Override
    protected void onResume() {
        super.onResume();
        setUser();
    }

    private void begin() {
        this.profilePhotoForm = findViewById(R.id.ivProfileForm);
        this.btnAddPhotoForm = findViewById(R.id.ibAddPhotoProfileForm);
        this.etUserName = findViewById(R.id.etNameUserForm);
        this.etUserEmail = findViewById(R.id.etEmailUserForm);
        this.etUserPhone = findViewById(R.id.etPhoneUserForm);
        this.btnConfirmProfile = findViewById(R.id.btnConfirmProfileForm);
        fields = new ArrayList<EditText>(Arrays.asList(etUserName,etUserPhone,etUserEmail));
        btnConfirmProfile.setOnClickListener(this::handleUpdate);
    }
    private void handleUpdate(View view){
        ResponseTaker responseTaker = new ResponseTaker() {
            @Override
            public void takeResponse(ResponseObj body) {
                tinyAlert("Perfil actualizado",false);
                goToLayout(UserProfile.class);
            }

            @Override
            public void manageMessage(String status,String mssg) {
                switch (status){
                    case "209":
                        snackBar("Este correo ya esta registrado",false);
                        break;
                    default:
                        snackBar(mssg,true);
                }
            }
        };
        User user = takeUser();
        if(!DAO.isNullOrEmpty(user)) {
            UserDAO userDAO = new UserDAO();
            SharedPreferences userSP = getSharedPreferences("USER", MODE_PRIVATE);
            userDAO.updateUser(userSP.getInt("user_id", 1002), user, responseTaker);
        }
    }

    private User takeUser(){
        try {
            String name = etUserName.getText().toString();
            String phone = etUserPhone.getText().toString();
            String email = etUserEmail.getText().toString();
            //String pass = etUserPss.getText().toString();
            validVoids(fields);
            validEmail(email);
            //validPass(pass);
            validPhone(phone);
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPhone(phone);
            return user;
        }
        catch (Exception e){
            tinyAlert(e.getMessage(),false);
            return null;
        }
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
    private void validPass(String pass) throws Exception{
        Pattern pattern =Pattern.compile("^(?=.*[a-zñ]+)(?=.*[A-ZÑ]+)(?=.*[0-9]+)(?=.*[!@#$%^&:;+*(){}\\-\\]\\[\\/<>]+)[a-zñA-ZÑ0-9!@#$%^&:;+*(){}\\-\\]\\[\\/<>]{8,}$");
        Matcher mather = pattern.matcher(pass);

        if (mather.find() != true) {
            System.out.println("Contreseña incompleta.");
            throw  new Exception("La contraseña debe tener 8 caracteres,1 minuscula, 1 mayuscula, 1 numero y 1 caracter especial.");
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


    private void setUser(){
        ResponseTaker responseTaker = new ResponseTaker() {
            @Override
            public void takeResponse(ResponseObj body) {
                ArrayList<Result> results = body.getResults();
                tinyAlert("Enter",true);
                if(!DAO.isNullOrEmpty(results)){
                    User user = new User();
                    for(Result r:results){
                        user = r.getUser();
                    }
                    etUserName.setText(user.getName());
                    etUserEmail.setText(user.getEmail());
                    etUserPhone.setText(user.getPhone());
                    //etUserPss.setText(user.getPassword());
                }
            }

            @Override
            public void manageMessage(String status, String mssg) {

            }
        };
        SharedPreferences userSP = getSharedPreferences("USER",MODE_PRIVATE);
        UserDAO userDAO = new UserDAO();
        userDAO.getUser(userSP.getInt("user_id",1002),responseTaker);
    }
}