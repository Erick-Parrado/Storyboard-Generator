package com.example.storyboard_generator;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.storyboard_generator.entities.Project;
import com.example.storyboard_generator.layout.AlertActor;
import com.example.storyboard_generator.layout.ExtrasSetter;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.model.ProjectDAO;
import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.Info;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class CreateProjectForm extends OurActivity {
    private static final int REQUEST_CAMERA_CODE = 485;
    public static final int ACTION_CAMERA_CODE = 234;
    private static final int ACTION_GALLERY_CODE = 905;
    private static final int REQUEST_GALLERY_CODE = 679;

    public static final String DATE_FORMAT = "yyyyMMdd_HHmmss";
    public static final String IMAGE_DIRECTORY = "ImageScalling";

    private String mini64;

    private ImageButton btnClose;
    private ImageButton btnDeleteProject;
    private ImageButton ibAddImage;
    private ImageButton ibAddImageG;
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
        btnClose = findViewById(R.id.ibClose);
        btnDeleteProject = findViewById(R.id.ibDeleteProject);
        etTittle = findViewById(R.id.etProjectNameForm);
        etProducer= findViewById(R.id.etProducer);
        etDescription = findViewById(R.id.etDescription);
        ibAddImage = findViewById(R.id.ibAddImage);
        ibAddImageG = findViewById(R.id.ibAddImageG);
        ivMini = findViewById(R.id.ivMini);
        ibAddImage.setOnClickListener(this::openCamera);
        ibAddImageG.setOnClickListener(this::openGallery);
        btConfirm = findViewById(R.id.btnConfirmarProject);
        btConfirm.setOnClickListener(this::handleCreateProject);
    }

    private  void handleCreateProject(View view){
        ResponseTaker responseTaker = new ResponseTaker() {
            @Override
            public void takeResponse(ResponseObj body,Info info) {
                AlertActor alertActor = new AlertActor() {
                    @Override
                    public void alertAction() {
                        goToLayout(Projects.class);
                    }
                };
                snackBar("Registro exitoso",false,"Iniciar Sesión", alertActor);
            }

            @Override
            public void manageMessage(String status,String mssg) {
               tinyAlert(mssg,false);
            }
        };
        Project project = takeProject();
        ProjectDAO projectDAO = new ProjectDAO();
        SharedPreferences userSD = getSharedPreferences("USER",MODE_PRIVATE);

        projectDAO.createProject(userSD.getInt("user_id",0),project,responseTaker);
    }

    private Project takeProject(){
        try {
            ArrayList<EditText> fields = new ArrayList<>(Arrays.asList(etTittle, etDescription, etProducer));
            validVoids(fields);
            Project project = new Project();
            project.setTitle(etTittle.getText().toString());
            project.setDescription(etDescription.getText().toString());
            project.setProducer(etProducer.getText().toString());
            project.setImage(mini64);
            return project;
        }
        catch (Exception e){
            tinyAlert(e.getMessage(),false);
            return new Project();
        }
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
            tinyAlert("Imagen seleccionada",true);
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
        try{
            Uri imageUri = data.getData();
            Bitmap imgBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
            ivMini.setImageBitmap(imgBitmap);
            ivMini.setMaxHeight(120);
            mini64 = encodeImage(imgBitmap);

        }catch (Exception e){
            tinyAlert("No se pudo seleccionar la imagen :(",false);
        }
    }

}