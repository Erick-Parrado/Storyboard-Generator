package com.example.storyboard_generator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapterProjects extends ArrayAdapter<ListDataProjects> {
    public ListAdapterProjects(@NonNull Context context, ArrayList<ListDataProjects> dataArrayList) {
        super(context, R.layout.activity_projects_items, dataArrayList);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ListDataProjects listData = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.activity_projects_items, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.ibProject);
        TextView listName = view.findViewById(R.id.tvTitleNameProject);
        TextView listStudio = view.findViewById(R.id.tvStudioProjects);

        listImage.setImageResource(listData.image);
        listName.setText(listData.title);
        listStudio.setText(listData.studio);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProjectTemplate.class);
                intent.putExtra("title", listData.title);
                intent.putExtra("studio", listData.studio);
                intent.putExtra("image", listData.image);
                getContext().startActivity(intent);
            }
        });

        return view;
    }

}
