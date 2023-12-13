package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class UserProfile extends AppCompatActivity {

    private ImageView profilePhoto;
    private ImageButton btnAddPhotoUP;
    private TextView tvUserName;
    private TextView tvUserEmail;
    private TextView tvUserPhone;
    private Button btnEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        begin();
    }

    private void begin() {
        this.profilePhoto = findViewById(R.id.ivProfileUP);
        this.btnAddPhotoUP = findViewById(R.id.ibAddPhotoUP);
        this.tvUserName = findViewById(R.id.tvUserNameUP);
        this.tvUserEmail = findViewById(R.id.tvEmailUP);
        this.tvUserPhone = findViewById(R.id.tvPhoneUP);
        this.btnEditProfile = findViewById(R.id.btnEditProfile);
    }
}