package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ListView;

public class TeamMembers extends AppCompatActivity {

    private ImageButton btnClose;
    private ListView lvMembers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_members);
        begin();
    }
    private void begin() {
        this.btnClose = findViewById(R.id.ibCloseMembers);
        this.lvMembers = findViewById(R.id.lvMembers);
    }
}