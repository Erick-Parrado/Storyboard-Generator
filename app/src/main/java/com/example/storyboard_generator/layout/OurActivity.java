package com.example.storyboard_generator.layout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class OurActivity extends AppCompatActivity {
    protected ArrayList<EditText> fields;


    protected String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,30,baos);
        byte[] b = baos.toByteArray();
        String imgDecodableString = Base64.encodeToString(b, Base64.DEFAULT);

        return imgDecodableString;
    }

    protected static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }
    protected void goToLayout(Class layout){
        try{
            Intent goProjects = new Intent(getApplicationContext(), layout);
            startActivity(goProjects);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    protected void validVoids(ArrayList<EditText> fields) throws Exception{
        for(EditText field:fields){
            if(field.getText().toString().isEmpty()){
                throw new Exception("Hay campos obligatorios vacios");
            }
        }
    }

    protected void clearFields(ArrayList<EditText> fields) {
        for(EditText field:fields){
            field.setText("");
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

    public  void simpleAlert(String tittle,String message){
        new AlertDialog.Builder(this)
                .setTitle(tittle)
                .setMessage(message)
                .setNeutralButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }
    public void seriousAlert(String tittle,String message,String positiveMssg,AlertActor positiveActor){
        new AlertDialog.Builder(this)
                .setTitle(tittle)
                .setMessage(message)
                .setPositiveButton(positiveMssg, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        positiveActor.alertAction();
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
    public void seriousAlert(String tittle,String message,String positiveMssg,AlertActor positiveActor, String negativeMssg,AlertActor negativeActor){
        new AlertDialog.Builder(this)
                .setTitle(tittle)
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
                }).show();
    }

}
