package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.storyboard_generator.databinding.ActivityEsceneTemplateBinding;
import com.example.storyboard_generator.databinding.ActivityProjectTemplateBinding;
import com.example.storyboard_generator.databinding.ActivityProjectsBinding;

import java.util.ArrayList;

public class ProjectTemplate extends AppCompatActivity {

    ActivityProjectTemplateBinding binding;
    ListAdapterProjects listAdapter;
    ArrayList<ListDataScene> dataArrayListScene = new ArrayList<>();
    ListDataProjects listDataProjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProjectTemplateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if(intent != null){
            String title = intent.getStringExtra("title");
            String studio = intent.getStringExtra("studio");
            int image = intent.getIntExtra("image", R.drawable.imggallery);

            binding.tvTitleProjectTemplate.setText(title);
            binding.tvStudioProjectTemplate.setText(studio);
            binding.ivImagePrincipalProject.setImageResource(image);

        }
    }
}
