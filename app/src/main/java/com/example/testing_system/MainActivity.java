package com.example.testing_system;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    AppDatabase db;
    TextInputLayout Login, Password;

    String LoginHolder, PasswordHolder;
    Button LOGIN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.textInputPassword);
        LOGIN = (Button)findViewById(R.id.idBtnLogin);
        LOGIN.setOnClickListener(view -> {
            MoveToLocalStrings();
            if (!Validate()) return;
            //if (db.userDao().checkIfUserWithLoginExists(Login.getEditText().getText().toString()))
            //    return;
            EmptyEditTextAfterDataInsert();
        });
    }

    public void EmptyEditTextAfterDataInsert(){
        Login.getEditText().getText().clear();
        Password.getEditText().getText().clear();}

    private void MoveToLocalStrings() {
        LoginHolder = Login.getEditText().getText().toString() ;
        PasswordHolder = Password.getEditText().getText().toString();}

    public boolean Validate(){
        return !TextUtils.isEmpty(LoginHolder) &&
                !TextUtils.isEmpty(PasswordHolder);}

    public void RedirectToRegister(View view) {
        Intent myIntent = new Intent(this, RegisterActivity.class);
        startActivity(myIntent);
    }


}