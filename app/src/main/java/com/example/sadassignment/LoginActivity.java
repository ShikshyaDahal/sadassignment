package com.example.sadassignment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sadassignment.model.UserModel;
import com.example.sadassignment.utils.DatabaseHelper;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText email;
    EditText password;
    Button login;
    ArrayList<UserModel> user=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.submit_area);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseHelper databaseHelper=new DatabaseHelper(LoginActivity.this);
                user=databaseHelper.getUser();

                for(int i=0;i<user.size();i++){

                    if(email.getText().toString().equals(user.get(i).getEmail()) && password.getText().toString().equals(user.get(i).getPassword())){
                        Intent intent=new Intent(LoginActivity.this,Dashboard.class);
                        startActivity(intent);
                    }
                }

            }
        });
    }
}
