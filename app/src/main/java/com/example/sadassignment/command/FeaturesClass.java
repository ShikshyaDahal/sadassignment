package com.example.sadassignment.command;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.sadassignment.facade.OrderService;
import com.example.sadassignment.facade.OrderServiceImplementation;

public class FeaturesClass {
    public void buy(String name, Context c) {
        OrderService faceade = new OrderServiceImplementation();
        String message = faceade.placeOrder(name);
        Log.e("Order", "Your product "+ name +" has been ordered and shipped");
        Toast.makeText(c, "Your product "+ name +" has been ordered and shipped", Toast.LENGTH_SHORT).show();

    }

    public void wishlist(String name,Context c) {
        Log.e("WishList", "Your Product "+ name +" has been added to wishlist");
        Toast.makeText(c, "Your product "+ name +" has been added to wishlist", Toast.LENGTH_SHORT).show();

    }
}
