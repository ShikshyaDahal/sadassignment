package com.example.sadassignment.command;

import android.content.Context;

public class OrderFeature implements FeatureInterface {
    private FeaturesClass features;
    private String name;
    private Context c;
    public OrderFeature(FeaturesClass features, String name, Context c){
        this.features=features;
    this.name=name;
    this.c=c;
    }

    @Override
    public void execute() {
        features.buy(name,c);
    }
}
