package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaneTemplate extends AppCompatActivity {

    private ImageButton btnBackArrow;
    private TextView tvPlaneTitle;
    private ImageView imagePlane;
    private TextView tvDurationPlane;
    private TextView tvShotPlane;
    private TextView tvPlanePlane;
    private TextView tvMovePlane;
    private TextView tvArgumentPlane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plane_template);
        begin();
    }
    private void begin(){
        this.btnBackArrow =  findViewById(R.id.ibBackArrow);
        this.tvPlaneTitle = findViewById(R.id.tvTitlePlane);
        this.imagePlane = findViewById(R.id.ivPlaneImage);
        this.tvDurationPlane = findViewById(R.id.tvDurationPlane);
        this.tvShotPlane = findViewById(R.id.tvShotPlane);
        this.tvPlanePlane = findViewById(R.id.tvPlanePlane);
        this.tvMovePlane = findViewById(R.id.tvMovePlane);
        this.tvArgumentPlane = findViewById(R.id.tvArgumentPlane);
    }
}