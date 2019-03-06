package com.example.sadassignment.command;

import com.example.sadassignment.command.FeatureInterface;

import java.util.ArrayList;

public class FeatureInvoker {
    private ArrayList<FeatureInterface> history=new ArrayList<>();
    public void executeOperations(FeatureInterface featureInterface){
        history.add(featureInterface);
        featureInterface.execute();
    }
}
