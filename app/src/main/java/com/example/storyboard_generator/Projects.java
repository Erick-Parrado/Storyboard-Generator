package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener{

    private ListView listView;
    private Button btnProject;
    private EditText nameProject;
    private EditText productProject;
    private List<String> Lista = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        begin();
        btnProject.setOnClickListener(this);
        listView.setOnItemClickListener(this);



      /*  listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewEscene();
            }
        });*/
    }

    public void onClick (View view){
        switch (view.getId()){
            case R.id.btnConfirmar:
                String texto = productProject.getText().toString().trim();
                Lista.add(texto);
                productProject.getText().clear();
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
                listView.setAdapter(adapter);
        }
    }

    private void addNewEscene(){

    }
    private void begin(){
    this.listView = findViewById(R.id.listView);
    this.btnProject = findViewById(R.id.btnConfirmar);
    this.nameProject = findViewById(R.id.etProjectName);
    this.productProject = findViewById(R.id.etProductoraProject);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    /*@Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }*/
}