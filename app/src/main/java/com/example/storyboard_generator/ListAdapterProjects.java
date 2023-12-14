package com.example.storyboard_generator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.storyboard_generator.entities.Project;

import java.util.ArrayList;

public class ListAdapterProjects extends ArrayAdapter<Project> {
    public ListAdapterProjects(@NonNull Context context, ArrayList<Project> dataProject) {
        super(context, R.layout.activity_projects_items, dataProject);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        Project itemProject = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_projects_items, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.ibProject);
        TextView listName = view.findViewById(R.id.tvTitleNameProject);
        TextView listStudio = view.findViewById(R.id.tvStudioProjects);

        //listImage.setImageResource(listData.image);
        listName.setText(itemProject.getTitle());
        listStudio.setText(itemProject.getProducer());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProjectTemplate.class);
                intent.putExtra("proj_id", itemProject.getId());
                Toast.makeText(getContext(),itemProject.getId(),Toast.LENGTH_SHORT);
                getContext().startActivity(intent);
            }
        });

        return view;
    }

}
