package com.example.storyboard_generator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.storyboard_generator.entities.Project;
import com.example.storyboard_generator.entities.User;
import com.example.storyboard_generator.layout.AlertActor;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.model.ProjectDAO;
import com.example.storyboard_generator.model.ResponseObj;
import com.example.storyboard_generator.model.ResponseTaker;
import com.example.storyboard_generator.model.UserDAO;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

public class CreateProjectForm extends OurActivity {

    private static final int REQUEST_CAMERA_CODE = 485;
    public static final int ACTION_CAMERA_CODE = 234;
    private static final int ACTION_GALLERY_CODE = 905;
    private static final int REQUEST_GALLERY_CODE = 679;

    public static final String DATE_FORMAT = "yyyyMMdd_HHmmss";
    public static final String IMAGE_DIRECTORY = "ImageScalling";

    private String mini64;

    private Button btAddImage;
    private Button btAddImageG;
    private EditText etTittle;
    private EditText etDescription;
    private EditText etProducer;
    private ImageView ivMini;

    private Button btConfirm;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project_form);
        begin();
    }

    private void begin(){
        etTittle = findViewById(R.id.etTittle);
        etProducer= findViewById(R.id.etProducer);
        etDescription = findViewById(R.id.etDescription);
        btAddImage = findViewById(R.id.tvAddImage);
        btAddImageG = findViewById(R.id.tvAddImageG);
        ivMini = findViewById(R.id.ivMini);
        btAddImage.setOnClickListener(this::openCamera);
        btAddImageG.setOnClickListener(this::openGallery);
        btConfirm = findViewById(R.id.btnConfirmarProject);
        btConfirm.setOnClickListener(this::handleCreateUser);
    }

    private  void handleCreateUser(View view){
        ResponseTaker responseTaker = new ResponseTaker() {
            @Override
            public void takeResponse(ResponseObj body) {
                AlertActor alertActor = new AlertActor() {
                    @Override
                    public void alertAction() {
                        goToLayout(Login.class);
                    }
                };
                snackBar("Registro exitoso",false,"Iniciar Sesión", alertActor);
            }
        };
        try{
            Project project = takeProject();
            ProjectDAO projectDAO = new ProjectDAO();
            projectDAO.createProject(1001,responseTaker);
        }catch (Exception e){
            snackBar(e.getMessage(),true);
        }
    }

    private Project takeProject(){
        Project project = new Project();
        project.setTitle(etTittle.getText().toString());
        project.setDescription(etDescription.getText().toString());
        project.setProducer(etProducer.getText().toString());
        return project;
    }
    private void validVoids(){

    }

    private void requestPermissionCamera(){
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.CAMERA}, REQUEST_CAMERA_CODE);
        Log.i("Camera Permission","I am accessing to camera");
    }
    private void requestPermissionStorage(){
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_GALLERY_CODE);
        Log.i("Gallery Permission","I am accessing to gallery");
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        String permission=null;
        switch (requestCode){
            case REQUEST_CAMERA_CODE:
                permission="camara";
                break;
            case REQUEST_GALLERY_CODE:
                permission="galeria";
                break;
            default:
                return;
        }
        if(grantResults[0] != PackageManager.PERMISSION_GRANTED){
            noPermisionAlert(permission);
        }
        else {
            View view = findViewById(android.R.id.content);
            switch (requestCode) {
                case REQUEST_CAMERA_CODE:
                        openCamera(view);
                    break;
                case REQUEST_GALLERY_CODE:
                        openGallery(view);
                    break;
            }
        }
    }


    private void openCamera(View view) {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityIfNeeded(intent, ACTION_CAMERA_CODE);
            }
        }
        else{requestPermissionCamera();}
    }
    private void openGallery(View view) {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_PICK);
            intent.setType("image/*");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityIfNeeded(intent, ACTION_GALLERY_CODE);
            }
        }
        else{requestPermissionStorage();}
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == ACTION_CAMERA_CODE || requestCode == ACTION_GALLERY_CODE) && resultCode == RESULT_OK){
            tinyAlert("Image taken",true);
            switch (requestCode){
                case ACTION_CAMERA_CODE:
                    processCamera(data);
                    break;
                case ACTION_GALLERY_CODE:
                    processGallery(data);
                    break;
            }
            //snackBar(encodeImage(imgBitmap).length()+"",true);
        }

    }

    private void processCamera(Intent data){
        Bundle extras = data.getExtras();
        Bitmap imgBitmap = (Bitmap) extras.get("data");
        ivMini.setImageBitmap(imgBitmap);
        ivMini.setMinimumHeight(120);
        mini64 = encodeImage(imgBitmap);
    }

    private void processGallery(Intent data){
        Uri imageUri = data.getData();
        Bitmap imgBitmap = BitmapFactory.decodeFile(imageUri.toString());
        ivMini.setImageURI(imageUri);
        mini64 = encodeImage(imgBitmap);
    }

    private String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,30,baos);
        byte[] b = baos.toByteArray();
        String imgDecodableString = Base64.encodeToString(b, Base64.DEFAULT);

        return imgDecodableString;
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

}