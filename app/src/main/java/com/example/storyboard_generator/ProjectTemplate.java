package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.storyboard_generator.databinding.ActivityProjectTemplateBinding;

import java.util.ArrayList;

public class ProjectTemplate extends AppCompatActivity {

    ActivityProjectTemplateBinding binding;
    ListAdapterScene listAdapter;
    ArrayList<ListDataScene> dataArrayList = new ArrayList<>();
    ListDataScene listDataScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = this.getIntent();
        if(intent != null){
            binding = ActivityProjectTemplateBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            String title = intent.getStringExtra("title");
            String studio = intent.getStringExtra("studio");
            int image = intent.getIntExtra("image", R.drawable.imggallery);

            binding.tvTitleProjectTemplate.setText(title);
            binding.tvStudioProjectTemplate.setText(studio);
            binding.ivImagePrincipalProject.setImageResource(image);
        } else {
            binding = ActivityProjectTemplateBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            String[] titleList = {"El viaje de Chihiro", "Young Justice","Kimetsu No Yaiba"};
            String[] sceneryList = {"Ghibli", "CN", "Uffotable"};
            String[] spaceList = {"Ghibli", "CN", "Uffotable"};
            String[] dayTimeList = {"Ghibli", "CN", "Uffotable"};
            String[] durationList = {"Ghibli", "CN", "Uffotable"};

            for (int i = 0; i < titleList.length; i++){
                listDataScene = new ListDataScene(titleList[i], sceneryList[i], spaceList[i],dayTimeList[i], durationList[i]);
                dataArrayList.add(listDataScene);
            }

            listAdapter = new ListAdapterScene(ProjectTemplate.this, dataArrayList);
            binding.listViewScenes.setAdapter(listAdapter);
            binding.listViewScenes.setClickable(true);

            for (int i = 0; i < listAdapter.getCount(); i++) {
                View view = listAdapter.getView(i, null, null);
                final int finalI = i;
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ProjectTemplate.this, ProjectTemplate.class);
                        intent.putExtra("title", titleList[finalI]);
                        intent.putExtra("scenery", sceneryList[finalI]);
                        intent.putExtra("space", spaceList[finalI]);
                        intent.putExtra("dayTime", dayTimeList[finalI]);
                        intent.putExtra("duration", durationList[finalI]);
                        startActivity(intent);
                    }
                });
            }
        }
    }
}
