package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class CreateEsceneForm extends AppCompatActivity {

    private ImageButton btnClose;
    private ImageButton btnDeleteScene;
    private EditText etPositionScene;
    private EditText etDurationScene;
    private EditText etSceneryScene;
    private EditText etDescriptionScene;
    //private EditText etTimeScene;
    private Button btnCOnfirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_escene_form);
    }
    private void begin() {
        this.btnClose = findViewById(R.id.ibClose);
        this.btnDeleteScene = findViewById(R.id.ibDeleteScene);
        this.etPositionScene = findViewById(R.id.etDescriptionSceneForm);
        this.etDurationScene = findViewById(R.id.etDurationSceneForm);
        this.etSceneryScene = findViewById(R.id.etScenerySceneForm);
        this.etDescriptionScene = findViewById(R.id.etDescriptionSceneForm);
        //this.etTimeScene = findViewById(R.id.etTimeSceneForm);
        this.btnCOnfirm = findViewById(R.id.btnConfirmarScene);
    }
}