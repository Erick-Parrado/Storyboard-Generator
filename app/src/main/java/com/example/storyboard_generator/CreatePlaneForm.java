package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CreatePlaneForm extends AppCompatActivity {

    private ImageButton btnClose;
    private ImageButton btnDeletePlane;
    private EditText etPositionPlane;
    //private EditText etTypePlane;
    private EditText etDurationPlane;
    //private EditText etShotPlane;
    //private EditText etMovePlane;
    private EditText etDescriptionPlane;
    private Button btnConfirmPlane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plane_form);
        begin();
    }

    private void begin() {
        this.btnClose = findViewById(R.id.ibClose);
        this.btnDeletePlane = findViewById(R.id.ibDeletePlane);
        this.etPositionPlane = findViewById(R.id.etPositionPlaneForm);
        //this.etTypePlane = findViewById(R.id.etTypePlaneForm);
        this.etDurationPlane = findViewById(R.id.etDurationPlaneForm);
        //this.etShotPlane = findViewById(R.id.etShotPlaneForm);
        //this.etMovePlane = findViewById(R.id.etMovePlaneForm);
        this.etDescriptionPlane = findViewById(R.id.etDescriptionPlaneForm);
        this.btnConfirmPlane = findViewById(R.id.btnConfirmPlane);
    }
}