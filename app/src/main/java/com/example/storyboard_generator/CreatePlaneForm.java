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

    //para el dropdown del formulario
    String[] itemPlane =  {"Dia", "Tarde", "Noche", "Madrugada"};
    String[] itemShot =  {"Vertical", "Horizontal"};
    String[] itemMove =  {"Vertical", "Horizontal", "Paneo"};
    private AutoCompleteTextView autoCompletePlane;
    private AutoCompleteTextView autoCompleteShot;
    private AutoCompleteTextView autoCompleteMove;

    ArrayAdapter<String> adapterItemsPlane;
    ArrayAdapter<String> adapterItemsShot;
    ArrayAdapter<String> adapterItemsMove;
    //---

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plane_form);
        begin();

        //para el dropdown del formulario
        adapterItemsPlane = new ArrayAdapter<String>(this, R.layout.activity_items_forms, itemPlane);
        adapterItemsShot = new ArrayAdapter<String>(this, R.layout.activity_items_forms, itemShot);
        adapterItemsMove = new ArrayAdapter<String>(this, R.layout.activity_items_forms, itemMove);

        autoCompletePlane.setAdapter(adapterItemsPlane);
        autoCompleteShot.setAdapter(adapterItemsShot);
        autoCompleteMove.setAdapter(adapterItemsMove);
        autoCompletePlane.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemPlane = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(CreatePlaneForm.this, "Item:" + itemPlane, Toast.LENGTH_SHORT).show();
            }
        });

        autoCompleteShot.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemShot = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(CreatePlaneForm.this, "Item:" + itemShot, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompletePlane.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemMove = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(CreatePlaneForm.this, "Item:" + itemMove, Toast.LENGTH_SHORT).show();
            }
        });
        //---
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

        this.autoCompletePlane = findViewById(R.id.autoCompletePlane);
        this.autoCompleteShot = findViewById(R.id.autoCompleteShot);
        this.autoCompleteMove = findViewById(R.id.autoCompleteMove);

    }
}