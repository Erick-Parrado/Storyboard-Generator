package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class CreateEsceneForm extends AppCompatActivity {

    private ImageButton btnClose;
    private ImageButton btnDeleteScene;
    private EditText etPositionScene;
    private EditText etDurationScene;
    private EditText etSceneryScene;
    private EditText etDescriptionScene;
    //private EditText etTimeScene;
    private Button btnCOnfirm;


    //para el dropdown del formulario
    String[] item =  {"Dia", "Tarde", "Noche", "Madrugada"};
    private AutoCompleteTextView autoCompleteTime;
    ArrayAdapter<String> adapterItems;
    //---

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_escene_form);
        begin();

        //para el dropdown del formulario
        adapterItems = new ArrayAdapter<String>(this, R.layout.activity_items_forms, item);

        autoCompleteTime.setAdapter(adapterItems);

        autoCompleteTime.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemPlane = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(CreateEsceneForm.this, "Item:" + itemPlane, Toast.LENGTH_SHORT).show();
            }
        });
        //---
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

        this.autoCompleteTime = findViewById(R.id.autoCompleteTime);
    }
}