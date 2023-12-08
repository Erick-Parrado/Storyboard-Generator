package com.example.storyboard_generator.listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.storyboard_generator.R;

import java.util.List;

public class ListAdapter /*extends ArrayAdapter<Model>*/ {
/*
    private List<Model> modelList;
    private Context context;
    private int resourceLayout;

    public ListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Model> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resourceLayout = resource;
        this.modelList = objects;
    }
        View view = convertView;

        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.activity_projects, null);


        Model model = modelList.get(position);


        //Karen, si no puedes meter esto en un imageButton, lo cambias por un imageView tanto aquí como en el layout y lo linkeas
        ImageButton imgbtnProject = view.findViewById(R.id.ibProject);
        imgbtnProject.setImageResource(model.getImageResource());

        TextView ProjectName = view.findViewById(R.id.tvTitleNameProject);
        ProjectName.setText(model.getProjectName());

        TextView studioProject = view.findViewById(R.id.tvStudioProjects);
        studioProject.setText(model.getStudio());

        TextView editeTimeProject = view.findViewById(R.id.tvEditeTime);
        editeTimeProject.setText(model.getEditTime());


            return  view;
    }*/
}
