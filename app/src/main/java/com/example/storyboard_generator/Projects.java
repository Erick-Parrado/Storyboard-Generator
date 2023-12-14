package com.example.storyboard_generator;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.storyboard_generator.api.ResponseObj;
import com.example.storyboard_generator.api.ResponseTaker;
import com.example.storyboard_generator.api.Result;
import com.example.storyboard_generator.databinding.ActivityProjectsBinding;
import com.example.storyboard_generator.entities.Project;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.model.DAO;
import com.example.storyboard_generator.model.TeamDAO;
//import com.example.storyboard_generator.listview.ListAdapter;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.prefs.Preferences;


public class Projects extends OurActivity {

    private ImageButton btnBackArrow;
    private ImageButton btnUser;
    private ImageButton btnSettings;
    private ImageButton btnAddProjects;
    private ImageButton btnJoin;

    ActivityProjectsBinding binding;
    ListAdapterProjects listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        begin();
        //VOjito eso no se quita de ahi V
        binding = ActivityProjectsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //^Ojito eso no se quita de ahi ^

    }

    @Override
    protected void onResume() {
        super.onResume();
        getProjectList();
    }

    private void begin(){
        this.btnBackArrow =  findViewById(R.id.ibBackArrow);
        this.btnUser = findViewById(R.id.ibUser);
        this.btnSettings = findViewById(R.id.ibSettings);
        this.btnAddProjects = findViewById(R.id.ibAddProjects);
        this.btnJoin = findViewById(R.id.ibJoin);

        }

        private void setProjectList(ArrayList<Project> projects){
            listAdapter = new ListAdapterProjects(Projects.this, projects);
            binding.lvProjects.setAdapter(listAdapter);
            binding.lvProjects.setClickable(true);
        }

        private void getProjectList(){
            tinyAlert(":v",false);
            ResponseTaker responseTaker = new ResponseTaker() {
                @Override
                public void takeResponse(ResponseObj body) {
                    ArrayList<Project> projects = new ArrayList<>();
                    ArrayList<Result> results = body.getResults();
                    if(!DAO.isNullOrEmpty(results)){
                        for(Result r:results){
                            projects.add(r.getProject());
                        }
                    }
                    setProjectList(projects);
                }

                @Override
                public void manageMessage(String status, String mssg) {
                        tinyAlert(status+":"+mssg,false);
                }
            };
            TeamDAO teamDAO = new TeamDAO();
            SharedPreferences dataSP = getSharedPreferences("USER",MODE_PRIVATE);
            int user_id = dataSP.getInt("user_id",0);
            teamDAO.getProjects(1001,responseTaker);
        }

}
