package com.example.storyboard_generator.layout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyboard_generator.Projects;
import com.example.storyboard_generator.R;
import com.google.android.material.snackbar.Snackbar;

public class OurActivity extends AppCompatActivity {

    protected void goToLayout(Class layout){
        try{
            Intent goProjects = new Intent(getApplicationContext(), layout);
            startActivity(goProjects);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    protected void snackBar(String message,boolean tiny){
        View view = findViewById(android.R.id.content);
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).show();
    }


    protected void snackBar(String message,boolean tiny,String actor,SnackActor snackActor){
        View view = findViewById(android.R.id.content);
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).setAction(actor, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackActor.snackAction();
            }
        }).show();
    }

    protected void snackBar(String message,boolean tiny,String action){
        View view = findViewById(android.R.id.content);
        Snackbar snackbar = Snackbar.make(getApplicationContext(),view,message,(tiny)?Snackbar.LENGTH_SHORT:Snackbar.LENGTH_LONG)
                .setAction(action, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        snackbar.show();
    }

    protected void tinyAlert(String message,boolean tiny){
        Toast.makeText(this,message,(tiny)?Toast.LENGTH_SHORT:Toast.LENGTH_LONG).show();
    }
    public void seriousAlert(String title,String message,String positive_mssg){
        new AlertDialog.Builder(this)
                .setTitle("Alerta de permisos")
                .setMessage("No se han concedido permisos para el acceso al Por favor, activarlos desde ajustes para continuar con el uso de la aplicacion")
                .setPositiveButton("Ajustes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package",getPackageName(),null));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).show();
    }
    public void seriousAlert(String title,String message,String positive_mssg,String negative_mssg){
        new AlertDialog.Builder(this)
                .setTitle("Alerta de permisos")
                .setMessage("No se han concedido permisos para el acceso al Por favor, activarlos desde ajustes para continuar con el uso de la aplicacion")
                .setPositiveButton("Ajustes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                Uri.fromParts("package",getPackageName(),null));
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                }).show();
    }

}
