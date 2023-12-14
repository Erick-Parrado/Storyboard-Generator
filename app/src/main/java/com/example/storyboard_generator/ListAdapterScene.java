package com.example.storyboard_generator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.storyboard_generator.entities.Scene;

import java.util.ArrayList;

public class ListAdapterScene extends ArrayAdapter<Scene> {
    public ListAdapterScene(@NonNull Context context, ArrayList<Scene> dataArrayListScene) {
        super(context, R.layout.activity_escenes_item, dataArrayListScene);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Scene itemScene = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_escenes_item, parent, false);
        }

        TextView listName = view.findViewById(R.id.tvEsceneTitlePT);
        TextView listScenery = view.findViewById(R.id.tvSceneryPT);
        TextView listSpace = view.findViewById(R.id.tvSpacePT);
        TextView listDayTime = view.findViewById(R.id.tvDayTimePT);
        TextView listDuration = view.findViewById(R.id.tvTimeDurationPT);

        listName.setText("Escena #"+itemScene.getNumber());
        listScenery.setText(itemScene.getPlace());
        listSpace.setText(itemScene.getSpace());
        listDayTime.setText(itemScene.getDayTime());
        listDuration.setText(itemScene.getDuration());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SceneTemplate.class);
                intent.putExtra("id", itemScene.getId());
                getContext().startActivity(intent);
            }
        });

        return view;
    }

}
