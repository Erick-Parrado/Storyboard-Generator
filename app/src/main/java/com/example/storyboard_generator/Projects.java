package com.example.storyboard_generator;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.example.storyboard_generator.databinding.ActivityProjectsBinding;
//import com.example.storyboard_generator.listview.ListAdapter;

import java.util.ArrayList;


public class Projects extends AppCompatActivity {
    ActivityProjectsBinding binding;
    ListAdapterProjects listAdapter;
    ArrayList<ListDataProjects> dataArrayList = new ArrayList<>();
    ListDataProjects listDataProjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityProjectsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {R.drawable.imggallery, R.drawable.logo, R.drawable.uniempresarial};
        String[] titleList = {"El viaje de Chihiro", "Young Justice","Kimetsu No Yaiba"};
        String[] studioList = {"Ghibli", "CN", "Uffotable"};

        for (int i = 0; i < imageList.length; i++){
            listDataProjects = new ListDataProjects(titleList[i], studioList[i], imageList[i]);
            dataArrayList.add(listDataProjects);
        }
        listAdapter = new ListAdapterProjects(Projects.this, dataArrayList);
        binding.listView.setAdapter(listAdapter);
        binding.listView.setClickable(true);
    }
}
