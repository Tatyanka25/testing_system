package com.example.testing_system;

import androidx.annotation.NonNull;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    EditText Login, Password;
    Button LOGINbtn;
    TextView signupRedirectText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login = findViewById(R.id.idEdtuserLogin);
        Password = findViewById(R.id.idEdtuserPassword);
        LOGINbtn = findViewById(R.id.idBtnLogin);
        signupRedirectText = findViewById(R.id.idBtnBacktoRegister);
        LOGINbtn.setOnClickListener(new viewRegisterClicked() {

    @Override
    public void onClick(View view) {
        if (!validateLogin() | !validatePassword()) {
        } else {
            checkUser();
        }
    }});
        signupRedirectText.setOnClickListener(new viewRegisterClicked() {

    @Override
    public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
    public Boolean validateLogin() {
        String val = Login.getText().toString();
        if (val.isEmpty()) {
            Login.setError("Login cannot be empty");
            return false;
        } else {
            Login.setError(null);
            return true;
        }
    }
    public Boolean validatePassword(){
        String val = Password.getText().toString();
        if (val.isEmpty()) {
            Password.setError("Password cannot be empty");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }
    public void checkUser(){
        String userUsername = Login.getText().toString().trim();
        String userPassword = Password.getText().toString().trim();
        DBHandler reference = DBHandler.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    loginUsername.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)) {
                        loginUsername.setError(null);
                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        loginPassword.setError("Invalid Credentials");
                        loginPassword.requestFocus();
                    }
                } else {
                    loginUsername.setError("User does not exist");
                    loginUsername.requestFocus();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}