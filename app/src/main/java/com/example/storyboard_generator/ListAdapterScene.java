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

import java.util.ArrayList;

public class ListAdapterScene extends ArrayAdapter<ListDataScene> {
    public ListAdapterScene(@NonNull Context context, ArrayList<ListDataScene> dataArrayListScene) {
        super(context, R.layout.activity_escenes_item, dataArrayListScene);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListDataScene listData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_escenes_item, parent, false);
        }

        TextView listName = view.findViewById(R.id.tvEsceneTitlePT);
        TextView listScenery = view.findViewById(R.id.tvSceneryPT);
        TextView listSpace = view.findViewById(R.id.tvSpacePT);
        TextView listDayTime = view.findViewById(R.id.tvDayTimePT);
        TextView listDuration = view.findViewById(R.id.tvTimeDurationPT);

        listName.setText(listData.title);
        listScenery.setText(listData.scenery);
        listSpace.setText(listData.space);
        listDayTime.setText(listData.dayTime);
        listDuration.setText(listData.duration);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SceneTemplate.class);
                intent.putExtra("title", listData.title);
                intent.putExtra("studio", listData.scenery);
                intent.putExtra("image", listData.space);
                intent.putExtra("image", listData.dayTime);
                intent.putExtra("image", listData.duration);
                getContext().startActivity(intent);
            }
        });

        return view;
    }

}
