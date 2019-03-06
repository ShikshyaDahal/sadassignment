package com.example.sadassignment.command;

import android.content.Context;

import com.example.sadassignment.command.FeatureInterface;
import com.example.sadassignment.command.FeaturesClass;

public class WishlistFeature implements FeatureInterface {
    private FeaturesClass features;
    private String name;
    private Context c;
    public WishlistFeature(FeaturesClass features, String name,Context c) {
        this.features = features;
        this.name=name;
        this.c=c;
    }

    @Override
    public void execute() {
        features.wishlist(name,c);
    }
}
