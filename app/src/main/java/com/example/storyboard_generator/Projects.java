package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Projects extends AppCompatActivity {
    private ImageButton backArrow;
    private ImageButton AddProjects;
    private ImageButton Unirse;
    private ImageButton perfilUser;
    private ImageButton Settings;

    @Override
    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_projects);
        backArrow = findViewById(R.id.ibPinClose);
        this.AddProjects = findViewById(R.id.ibAddProjects);
        this.Unirse = findViewById(R.id.ibUnirse);
        this.perfilUser = findViewById(R.id.ibUser);
        this.Settings = findViewById(R.id.ibSettings);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Projects.this, Register.class));
                startActivity(new Intent(Projects.this, CreateProjectForm.class));
                startActivity(new Intent(Projects.this, TeamMembers.class));
            }
        });
        AddProjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(getApplicationContext(), CreateProjectForm.class);
                startActivity(go);
            }
        });
        Unirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go = new Intent(getApplicationContext(), Pin.class);
                startActivity(go);
            }
        });
        perfilUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(go);
            }
        });
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), com.example.storyboard_generator.Settings.class);
                startActivity(go);
            }
        });


        /*LIST VIEW*/
        ArrayList<String> projects = new ArrayList<>();
        projects.add("Pixel Art");
        projects.add("Teravision Games");
        projects.add("Tan grande y jugando");

        ListView lvLista = findViewById(R.id.lvLista);

        ArrayAdapter<String> itemsAdpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, projects);

        lvLista.setAdapter(itemsAdpater);
    }

}