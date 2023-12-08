package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.storyboard_generator.listview.ListAdapter;
import com.example.storyboard_generator.listview.Model;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity{
/*
    private ListView listView;

    private List<Model> lista = new ArrayList<>();
    ListAdapter adapter = new ListAdapter(Projects.this,R.layout.activity_projects);

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
      /*  begin();
       lista.add(new Model(R.mipmap.ic_launcher, "Proyecto1","Ghibli","hace 12 seg"));

        listView.setAdapter(adapter);*/
    }

/*
    private void begin(){
    this.listView = findViewById(R.id.listView);
    }
*/

}