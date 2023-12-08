package com.example.storyboard_generator.listview;

public class Model {
    private int imageResource;
    private String projectName;
    private String studio;
    private String editTime;

    public Model(int imageResource, String projectName, String studio, String editTime) {
        this.imageResource = imageResource;
        this.projectName = projectName;
        this.studio = studio;
        this.editTime = editTime;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getStudio() {
        return studio;
    }

    public String getEditTime() {
        return editTime;
    }
}
