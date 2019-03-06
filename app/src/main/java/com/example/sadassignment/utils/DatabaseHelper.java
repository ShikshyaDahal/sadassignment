package com.example.sadassignment.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sadassignment.model.ProductModel;
import com.example.sadassignment.model.UserModel;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASENAME = "commerce";

    public DatabaseHelper(Context context) {
        super(context, DATABASENAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, address VARCHAR, email VARCHAR, password VARCHAR, phone VARCHAR)");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS product(id INTEGER PRIMARY KEY AUTOINCREMENT, productname VARCHAR, price VARCHAR, description VARCHAR )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void createUser(UserModel user) {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getWritableDatabase();
        cv.put("name", user.getName());
        cv.put("address", user.getAddress());
        cv.put("email", user.getEmail());
        cv.put("password", user.getPassword());
        cv.put("phone", user.getPhone());
        db.insert("user", null, cv);
    }

    public void createproduct(ProductModel product) {
        ContentValues cv1 = new ContentValues();
        SQLiteDatabase db1 = this.getWritableDatabase();
        cv1.put("productname", product.getName());
        cv1.put("description", product.getDescription());
        cv1.put("price", product.getPrice());
        db1.insert("product", null, cv1);
    }


    public ArrayList<ProductModel> readData() {
        ArrayList<ProductModel> al = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from product", null);
        if (c.getCount() > 0) {
            if (c.moveToNext()) {
                do {
                    ProductModel pm = new ProductModel();
                    pm.setId(c.getInt(c.getColumnIndex("id")));
                    pm.setName(c.getString(c.getColumnIndex("productname")));
                    pm.setDescription(c.getString(c.getColumnIndex("description")));
                    pm.setPrice(c.getString(c.getColumnIndex("price")));
                    al.add(pm);
                }
                while (c.moveToNext());
            }
        }

        c.close();
        db.close();
        return al;
    }
    public ArrayList<UserModel> getUser() {
        ArrayList<UserModel> users=new ArrayList<>();

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from user",null);
        if (c.getCount()>0){
            if (c.moveToFirst()) {
            do {
                String email=c.getString(c.getColumnIndex("email"));
                String password=c.getString(c.getColumnIndex("password"));
                String name=c.getString(c.getColumnIndex("name"));
                String address=c.getString(c.getColumnIndex("address"));
                String phone=c.getString(c.getColumnIndex("phone"));

                UserModel userModel=new UserModel.Builder().writeEmail(email).writePassword(password)
                        .writeName(name).writeAddress(address).writePhone(phone).build();
                users.add(userModel);
            }while (c.moveToNext());
            }
        }

        return users;

    }
}
