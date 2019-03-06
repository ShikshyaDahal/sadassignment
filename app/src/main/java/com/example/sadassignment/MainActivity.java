package com.example.sadassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sadassignment.model.UserModel;
import com.example.sadassignment.utils.DatabaseHelper;

public class MainActivity extends AppCompatActivity {
    Button signup;
    TextView login;
    UserModel user;
    EditText email, password, address, phone, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signup = findViewById(R.id.signup);
        login = findViewById(R.id.login);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        phone = findViewById(R.id.phone);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=new UserModel.Builder()
                        .writeEmail(email.getText().toString())
                        .writePassword(password.getText().toString())
                        .writeName(name.getText().toString())
                        .writeAddress(address.getText().toString())
                        .writePhone(phone.getText().toString())
                        .build();
                DatabaseHelper dbh = new DatabaseHelper(MainActivity.this);
                dbh.createUser(user);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}
