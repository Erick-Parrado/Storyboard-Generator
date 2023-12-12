package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.storyboard_generator.databinding.ActivityEsceneTemplateBinding;

import java.util.ArrayList;

public class SceneTemplate extends AppCompatActivity {

    ActivityEsceneTemplateBinding binding;
    ListAdapterProjects listAdapter;
    ArrayList<ListDataProjects> dataArrayList = new ArrayList<>();
    ListDataProjects listDataEscenes;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

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
                binding.tvDayTimePT.setText(dayTime);

            }
        }

    }
