package com.example.sadassignment.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.sadassignment.model.ProductModel;
import com.example.sadassignment.model.UserModel;

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
}
