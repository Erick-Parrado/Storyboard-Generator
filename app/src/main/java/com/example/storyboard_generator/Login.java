package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button btnLoginLogin;
    private Button btnRegisterLogin;
    public String textoT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.btnLoginLogin = findViewById(R.id.btnLoginLogin);
        this.btnRegisterLogin = findViewById(R.id.btnRegisterLogin);


        //Creación toast personalizado


        btnLoginLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent goProjects = new Intent(getApplicationContext(), Projects.class);
                startActivity(goProjects);
                Toast.makeText(Login.this, "Go Projects", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegisterLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goProjects = new Intent(getApplicationContext(), Register.class);
                startActivity(goProjects);
            }
        });
        /*ESTILOS TOAST*/
        //Básico
        Toast.makeText(this, "Prueba estilos Toast", Toast.LENGTH_SHORT).show();





        /*FORZAR TECLADO*/
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        }
    }
    //Personalizado
    public void toastStory(String textoT){
        LayoutInflater inflater = this.getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_informar,(ViewGroup)findViewById(R.id.layoutInformar));
        TextView textView = layout.findViewById(R.id.tvToastInformar);
        textView.setText(textoT);

        Toast toast = new Toast(this.getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.BOTTOM, 0, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
    }

}