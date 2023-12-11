package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.storyboard_generator.listview.ListAdapter;
import com.example.storyboard_generator.listview.Model;

import java.util.ArrayList;
import java.util.List;

public class Projects extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceSate) {
        super.onCreate(savedInstanceSate);
        setContentView(R.layout.activity_projects);

        ArrayList<String> projects = new ArrayList<>();
        projects.add("Pixel Art");
        projects.add("Teravision Games");
        projects.add("Tan grande y jugando");

        ListView lvLista = findViewById(R.id.lvLista);

        SharedPreferences SPManager = getSharedPreferences("CREDENTIALS", Context.MODE_PRIVATE);

        Toast.makeText(this,SPManager.getString("key",":v"), Toast.LENGTH_SHORT).show();

        ArrayAdapter<String> itemsAdpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, projects);

        lvLista.setAdapter(itemsAdpater);
    }

        /*Menú*/
        public boolean onCreateOptionsMenu(Menu menu) {
            super.onCreateOptionsMenu(menu);
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu1, menu);
            return true;
        }

        public void showPopup(View view){
            PopupMenu popup = new PopupMenu(this, view);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.menu1, popup.getMenu());
            popup.show();
        }
}
