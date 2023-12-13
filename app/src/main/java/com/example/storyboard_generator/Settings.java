package com.example.storyboard_generator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class Settings extends AppCompatActivity {

    private ImageButton btnTheme;
    private TextView tvTheme;
    private ImageButton btnInfo;
    private TextView tvInfo;
    private ImageButton btnExit;
    private TextView tvExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        begin();
    }
    private void begin() {
        this.btnTheme = findViewById(R.id.ibTheme);
        this.tvTheme = findViewById(R.id.tvTheme);
        this.btnInfo = findViewById(R.id.ibInfo);
        this.tvInfo = findViewById(R.id.tvInfo);
        this.btnExit = findViewById(R.id.ibExit);
        this.tvExit = findViewById(R.id.tvExit);
    }
}