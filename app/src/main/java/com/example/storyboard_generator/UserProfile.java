package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.Info;
import com.example.storyboard_generator.api.Result;
import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.model.DAO;
import com.example.storyboard_generator.model.UserDAO;

import java.util.ArrayList;

public class UserProfile extends OurActivity {
    private ImageView profilePhoto;
    private ImageButton btnAddPhotoUP;
    private TextView tvUserName;
    private TextView tvUserEmail;
    private TextView tvUserPhone;
    private Button btnEditProfile;
    private ImageButton ibBackArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        begin();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUser();
    }

    private void begin() {
        this.profilePhoto = findViewById(R.id.ivProfileUP);
        this.btnAddPhotoUP = findViewById(R.id.ibAddPhotoUP);
        this.tvUserName = findViewById(R.id.tvUserNameUP);
        this.tvUserEmail = findViewById(R.id.tvEmailUP);
        this.tvUserPhone = findViewById(R.id.tvPhoneUP);
        this.btnEditProfile = findViewById(R.id.btnEditProfile);
        this.ibBackArrow = findViewById(R.id.ibBackArrow);
        ibBackArrow.setOnClickListener(this::handleEditProfile);
        btnEditProfile.setOnClickListener(this::handleEditProfile);
    }

    private  void handleEditProfile(View view){
        goToLayout(EditUserForm.class);
    }
    private void setUser(){
        ResponseTaker responseTaker = new ResponseTaker() {
            @Override
            public void takeResponse(ResponseObj body,Info info) {
                ArrayList<Result> results = body.getResults();
                tinyAlert("Enter",true);
                if(!DAO.isNullOrEmpty(results)){
                    User user = new User();
                    for(Result r:results){
                        user = r.getUser();
                    }
                    tvUserName.setText(user.getName());
                    tvUserEmail.setText(user.getEmail());
                    tvUserPhone.setText(user.getPhone());
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