package com.example.sadassignment.activities;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sadassignment.R;
import com.example.sadassignment.adapter.CustomAdapter;
import com.example.sadassignment.model.ProductModel;
import com.example.sadassignment.utils.DatabaseHelper;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ListView listView;
    Button additem;
    ProductModel product;
    ArrayList<ProductModel> al = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        listView = findViewById(R.id.listview);
        additem = findViewById(R.id.additem);
        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder adb = new AlertDialog.Builder(Dashboard.this);
                View v1 = LayoutInflater.from(Dashboard.this).inflate(R.layout.additem_layout, null);
                adb.setView(v1);
                Button save = v1.findViewById(R.id.save);
                final EditText productname = v1.findViewById(R.id.productname);
                final EditText productdescription = v1.findViewById(R.id.productdescription);
                final EditText productprice = v1.findViewById(R.id.productprice);
                final AlertDialog ad = adb.create();
                ad.show();
                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        product = new ProductModel.Builder().writeProductName(productname.getText().toString())
                                .writeProductPrice(productprice.getText().toString())
                                .writeProductDescription(productdescription.getText().toString()).build();
                        DatabaseHelper dbh = new DatabaseHelper(Dashboard.this);
                        dbh.createproduct(product);
                        ad.dismiss();
                    }
                });

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseHelper dh = new DatabaseHelper(Dashboard.this);
        al = dh.readData();
        Log.e("data size", ""+al.size());
        listView.setAdapter(new CustomAdapter(Dashboard.this, al));

    }
}
