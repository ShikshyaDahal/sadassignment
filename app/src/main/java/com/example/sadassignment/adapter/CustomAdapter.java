package com.example.sadassignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sadassignment.Dashboard;
import com.example.sadassignment.R;
import com.example.sadassignment.model.ProductModel;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<ProductModel> al = new ArrayList<>();
    public CustomAdapter(Dashboard dashboard, ArrayList<ProductModel> al) {
        context = dashboard;
        this.al = al;
    }

    @Override
    public int getCount() {
        return al.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.customer_adapter, null);
        final TextView productname = convertView.findViewById(R.id.productname);
        final TextView productdescription = convertView.findViewById(R.id.productdescription);
        final TextView productprice = convertView.findViewById(R.id.productprice);
        productname.setText(al.get(position).getName());
        productdescription.setText(al.get(position).getDescription());
        productprice.setText(al.get(position).getPrice());
        return convertView;
    }
}
