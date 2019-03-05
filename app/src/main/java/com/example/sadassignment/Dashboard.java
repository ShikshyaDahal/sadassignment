package com.example.sadassignment;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Dashboard extends AppCompatActivity {
    ListView listView;
    Button additem;
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
                EditText productname = v1.findViewById(R.id.productname);
                EditText productdescription = v1.findViewById(R.id.productdescription);
                EditText productprice = v1.findViewById(R.id.productprice);

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                AlertDialog ad = adb.create();
                ad.show();
            }
        });

    }
}
