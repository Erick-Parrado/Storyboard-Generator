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
import com.example.storyboard_generator.databinding.ActivityProjectsBinding;
import com.example.storyboard_generator.layout.OurActivity;
import com.example.storyboard_generator.model.TeamDAO;
//import com.example.storyboard_generator.listview.ListAdapter;

import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.prefs.Preferences;


public class Projects extends OurActivity {

    private ImageButton btnBackArrow;
    private ImageButton btnUser;
    private ImageButton btnSettings;
    private ImageButton btnAddProjects;
    private ImageButton btnJoin;

    ActivityProjectsBinding binding;
    ListAdapterProjects listAdapter;
    ArrayList<ListDataProjects> dataArrayList = new ArrayList<>();
    ListDataProjects listDataProjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        begin();

    }

    private void begin(){
        this.btnBackArrow =  findViewById(R.id.ibBackArrow);
        this.btnUser = findViewById(R.id.ibUser);
        this.btnSettings = findViewById(R.id.ibSettings);
        this.btnAddProjects = findViewById(R.id.ibAddProjects);
        this.btnJoin = findViewById(R.id.ibJoin);

        }

        private void setProjectList(ArrayList<Projects> projects){
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
            binding.lvProjects.setAdapter(listAdapter);
            binding.lvProjects.setClickable(true);
        }

        private void getProjectList(){
            ResponseTaker responseTaker = new ResponseTaker() {
                @Override
                public void takeResponse(ResponseObj body) {
                    ArrayList<Projects> projects = new ArrayList<>();

                }

                @Override
                public void manageMessage(String status, String mssg) {
                        tinyAlert(status+":"+mssg,false);
                }
            };
            TeamDAO teamDAO = new TeamDAO();
            SharedPreferences dataSP = getSharedPreferences("USER",MODE_PRIVATE);
            int user_id = dataSP.getInt("user_id",0);
            teamDAO.getProjects(user_id);
        }

}
