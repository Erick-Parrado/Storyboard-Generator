package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.Result;
import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.model.DAO;
import com.example.storyboard_generator.model.UserDAO;

import java.util.ArrayList;

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

    private void begin() {
        this.profilePhotoForm = findViewById(R.id.ivProfileForm);
        this.btnAddPhotoForm = findViewById(R.id.ibAddPhotoProfileForm);
        this.etUserName = findViewById(R.id.etNameUserForm);
        this.etUserEmail = findViewById(R.id.etEmailUserForm);
        this.etUserPhone = findViewById(R.id.etPhoneUserForm);
        this.etUserPss = findViewById(R.id.etPssUserForm);
        this.btnConfirmProfile = findViewById(R.id.btnConfirmProfileForm);
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
                    etUserPss.setText(user.getPassword());
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