package com.example.testing_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    AppDatabase db;
    TextInputLayout Login, Password;
    Button LOGIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.textInputPassword);
        LOGIN = (Button)findViewById(R.id.idBtnLogin);
    }



    public void RedirectToLogin(View view) {
        Intent myIntent = new Intent(this, RegisterActivity.class);
        startActivity(myIntent);
    }


}