package com.example.storyboard_generator.api;

import com.example.storyboard_generator.api.ResponseObj;

public interface ResponseTaker {

    void takeResponse(ResponseObj body);

    void manageMessage(String status,String mssg);
}
