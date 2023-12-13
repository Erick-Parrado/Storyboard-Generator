package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.storyboard_generator.databinding.ActivityEsceneTemplateBinding;

import java.util.ArrayList;

public class SceneTemplate extends AppCompatActivity {

    private ImageButton btnBackArrow;
    private TextView tvSceneName;
    private ImageButton btnEditScene;
    private TextView tvScenery;
    private TextView tvSpace;
    private TextView tvDayTime;
    private TextView tvDurationScene;
    private TextView tvdescriptionScene;
    //private ListView lvPlane;
    private ImageButton btnAddPlanes;


    ActivityEsceneTemplateBinding binding;
    ListAdapterProjects listAdapter;
    ArrayList<ListDataProjects> dataArrayList = new ArrayList<>();
    ListDataProjects listDataEscenes;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            begin();

            binding = ActivityEsceneTemplateBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            Intent intent = this.getIntent();
            if(intent != null){
                String title = intent.getStringExtra("title");
                String scenery = intent.getStringExtra("scenary");
                String space = intent.getStringExtra("space");
                String dayTime = intent.getStringExtra("dayTime");

                binding.tvTitleEsceneTemplate.setText(title);
                binding.tvSceneryET.setText(scenery);
                binding.tvSpaceET.setText(space);
                binding.tvDayTimeET.setText(dayTime);

            }
        }
    private void begin(){
        this.btnBackArrow=  findViewById(R.id.ibBackArrow);
        this.tvSceneName = findViewById(R.id.tvTitleEsceneTemplate);
        this.btnEditScene = findViewById(R.id.ibEditEsceneInfo);
        this.tvScenery = findViewById(R.id.tvSceneryET);
        this.tvSpace = findViewById(R.id.tvSpaceET);
        this.tvDayTime = findViewById(R.id.tvDayTimeET);
        this.tvDurationScene = findViewById(R.id.tvDurationEsceneET);
        this.tvdescriptionScene= findViewById(R.id.tvDescriptionEsceneET);
        //this.lvPlane   = findViewById(R.id.lvPlane);
        this.btnAddPlanes  = findViewById(R.id.ibAddPlanes);
    }

    }
