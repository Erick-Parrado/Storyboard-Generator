package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.storyboard_generator.databinding.ActivityProjectTemplateBinding;

import java.util.ArrayList;

public class ProjectTemplate extends AppCompatActivity {

    private ImageButton btnBackArrow;

    private TextView titleProject;
    private ImageButton btnEditProject;
    private TextView pin;
    private TextView studioName;
    private ImageButton btnTeamView;

    private ImageView imageProject;
    private ImageButton btnAddScenes;
    //private ListView lvScenes;

    ActivityProjectTemplateBinding binding;
    ListAdapterScene listAdapter;
    ArrayList<ListDataScene> dataArrayList = new ArrayList<>();
    ListDataScene listDataScene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        begin();

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
            binding.lvScenes.setAdapter(listAdapter);
            binding.lvScenes.setClickable(true);

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

    private void begin(){
        this.btnBackArrow =  findViewById(R.id.ibBackArrow);
        this.titleProject = findViewById(R.id.tvTitleProjectTemplate);
        this.btnEditProject = findViewById(R.id.ibEditProjectInfo);
        this.pin = findViewById(R.id.tvSharePIN);
        this.studioName = findViewById(R.id.tvStudioProjectTemplate);
        this.btnTeamView = findViewById(R.id.ibTeamPT);
        this.imageProject = findViewById(R.id.ivImagePrincipalProject);
        //this.lvScenes = findViewById(R.id.lvScenes);
        this.btnAddScenes   = findViewById(R.id.ibAddScenes);
    }
}
