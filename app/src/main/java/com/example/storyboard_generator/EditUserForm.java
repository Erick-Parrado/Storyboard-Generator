package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class EditUserForm extends AppCompatActivity {

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
}