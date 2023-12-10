package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    private Button btnLoginLogin;
    private Button btnRegisterLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.btnLoginLogin = findViewById(R.id.btnLoginLogin);
        this.btnRegisterLogin = findViewById(R.id.btnRegisterLogin);

        btnLoginLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent goProjects = new Intent(getApplicationContext(), Projects.class);
                startActivity(goProjects);
            }
        });
        btnRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goProjects = new Intent(getApplicationContext(), Register.class);
                startActivity(goProjects);
            }
        });
    }
}