package com.example.storyboard_generator.layout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class OurActivity extends AppCompatActivity {

    protected void goToLayout(Class layout){
        try{
            Intent goProjects = new Intent(getApplicationContext(), layout);
            startActivity(goProjects);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    protected void validVoids(ArrayList<String> fields) throws Exception{
        for(String field:fields){
            if(field.isEmpty()){
                throw new Exception("Hay campos obligatorios vacios");
            }
        }

    }

    protected void goToLayout(Class layout,ExtrasSetter extrasSetter){
        try{
            Intent go = new Intent(getApplicationContext(), layout);
            extrasSetter.setExtras(go);
            startActivity(go);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    protected void snackBar(String message,boolean tiny){
        View view = findViewById(android.R.id.content);
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).show();
    }


    protected void snackBar(String message, boolean tiny, String actor, AlertActor alertActor){
        View view = findViewById(android.R.id.content);
        Snackbar.make(view,message,Snackbar.LENGTH_LONG).setAction(actor, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertActor.alertAction();
            }
        }).show();
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

    public void noPermisionAlert(String permission){
        AlertActor positiveActor = new AlertActor() {
            @Override
            public void alertAction() {
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                        Uri.fromParts("package",getPackageName(),null));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        };

        AlertActor negativeActor = new AlertActor() {
            @Override
            public void alertAction() {
                finish();
            }
        };


        seriousAlert("Permisos de "+permission,
                "No se han concedido permisos para el acceso al "+permission+".Por favor, activarlos desde ajustes para continuar con el uso de la aplicacion",
                "Ajustes",positiveActor,
                "Salir",negativeActor);
    }
    public void seriousAlert(String title,String message,String positiveMssg,AlertActor positiveActor, String negativeMssg,AlertActor negativeActor){
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveMssg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        positiveActor.alertAction();
                    }
                }).setNegativeButton(negativeMssg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        negativeActor.alertAction();
                    }
                })
                .setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

}
