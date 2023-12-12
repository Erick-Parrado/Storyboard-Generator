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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.storyboard_generator.layout.OurActivity;

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
    private Button btAddImage;
    private Button btAddImageG;
    private ImageView ivMini;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_project_form);
        begin();
    }

    private void begin(){
        btAddImage = findViewById(R.id.tvAddImage);
        btAddImageG = findViewById(R.id.tvAddImageG);
        ivMini = findViewById(R.id.ivMini);
        btAddImage.setOnClickListener(this::openCamera);
        btAddImageG.setOnClickListener(this::openGallery);
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
            case REQUEST_GALLERY_CODE:_CODE:
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

    }

    private void copyFile(File sourceFile, File destFile) throws IOException {
        if (!sourceFile.exists()) {
            return;
        }
    }

    private void processGallery(Intent data){
        Uri uriPhoto = data.getData();
        File file;
        File destFile;
        SimpleDateFormat dateFormatter;
        dateFormatter = new SimpleDateFormat(DATE_FORMAT, Locale.US);



        file = new File(Environment.getExternalStorageDirectory()
                + "/" + IMAGE_DIRECTORY);
        if (!file.exists()) {
            file.mkdirs();
        }
        Log.d(".PICK_GALLERY_IMAGE", "Selected image uri path :" + uriPhoto.toString());

        snackBar(uriPhoto.toString(),true);

        File sourceFile = new File(getPathFromGooglePhotosUri(uriPhoto));


        Bitmap imgBitmap = BitmapFactory.decodeFile(file.getPath());
        ivMini.setImageBitmap(imgBitmap);
        ivMini.setMinimumHeight(120);

    }

    public String getPathFromGooglePhotosUri(Uri uriPhoto) {
        if (uriPhoto == null)
            return null;

        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            ParcelFileDescriptor pfd = getContentResolver().openFileDescriptor(uriPhoto, "r");
            FileDescriptor fd = pfd.getFileDescriptor();
            input = new FileInputStream(fd);

            String tempFilename = getTempFilename(this);
            output = new FileOutputStream(tempFilename);

            int read;
            byte[] bytes = new byte[4096];
            while ((read = input.read(bytes)) != -1) {
                output.write(bytes, 0, read);
            }
            return tempFilename;
        } catch (IOException ignored) {
            // Nothing we can do
        } finally {
                closeSilently(input);
               closeSilently(output);
        }
        return null;
    }

    private static String getTempFilename(Context context) throws IOException {
        File outputDir = context.getCacheDir();
        File outputFile = File.createTempFile("image", "tmp", outputDir);
        return outputFile.getAbsolutePath();
    }

    private String encodeImage(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG,30,baos);
        byte[] b = baos.toByteArray();
        String imgDecodableString = Base64.encodeToString(b, Base64.DEFAULT);

        return imgDecodableString;
    }
    public static void closeSilently(Closeable c) {
        if (c == null)
            return;
        try {
            c.close();
        } catch (Throwable t) {
            // Do nothing
        }
    }

    public static Bitmap decodeBase64(String input)
    {
        byte[] decodedBytes = Base64.decode(input.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.length);
    }

}