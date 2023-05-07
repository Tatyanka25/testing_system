package com.example.testing_system;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testing_system.database.AppDatabase;
import com.google.android.material.textfield.TextInputLayout;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    AppDatabase db;
    TextInputLayout Login, Password;
    String LoginHolder, PasswordHolder;
    Button LoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.textInputEmail);
        Password = findViewById(R.id.textInputPassword);
        LoginBtn = findViewById(R.id.idBtnLogin);
        LoginBtn.setOnClickListener(view -> login());
    }

    private void login() {
        String userName = Login.getEditText().getText().toString();
        String password = Password.getEditText().getText().toString();
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) return;

        EmptyEditTextAfterDataInsert();
    }

    public void EmptyEditTextAfterDataInsert(){
        Login.getEditText().getText().clear();
        Password.getEditText().getText().clear();
    }

    public void RedirectToRegister(View view) {
        Intent myIntent = new Intent(this, RegisterActivity.class);
        startActivity(myIntent);
    }
}