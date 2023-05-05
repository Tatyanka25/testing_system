package com.example.testing_system;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends Activity {

    // creating variables for our edittext, button and dbhandler
    private TextInputLayout userLoginEdt, userPasswordEdt, userNameEdt, userSurnameEdt, userMiddleNameEdt, userDateOfBirthEdt, userEmailEdt, userNumberEdt, userQuestionEdt, userAnswerEdt;
    private Button RegisterBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);

        // initializing all our variables.
        userLoginEdt = findViewById(R.id.idEdtuserLogin);
        userPasswordEdt = findViewById(R.id.idEdtuserPassword);
        userNameEdt = findViewById(R.id.idEdtuserName);
        userSurnameEdt = findViewById(R.id.idEdtuserSurname);
        userMiddleNameEdt = findViewById(R.id.idEdtuserMiddleName);
        userDateOfBirthEdt = findViewById(R.id.idEdtuserDateOfBirth);
        userEmailEdt = findViewById(R.id.idEdtuserEmail);
        userNumberEdt = findViewById(R.id.idEdtuserNumber);
        userQuestionEdt = findViewById(R.id.idEdtuserQuestion);
        userAnswerEdt = findViewById(R.id.idEdtuserAnswer);
        RegisterBtn = findViewById(R.id.idBtnRegister);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        RegisterBtn.setOnClickListener(v -> {
            // below line is to get data from all edit text fields.
            String userLogin = userLoginEdt.getEditText().getText().toString();
            String userPassword = userPasswordEdt.getEditText().getText().toString();
            String userName = userNameEdt.getEditText().getText().toString();
            String userSurname = userSurnameEdt.getEditText().getText().toString();
            String userMiddleName = userMiddleNameEdt.getEditText().getText().toString();
            String userDateOfBirth = userDateOfBirthEdt.getEditText().getText().toString();
            String userEmail = userEmailEdt.getEditText().getText().toString();
            String userNumber = userNumberEdt.getEditText().getText().toString();
            String userQuestion = userQuestionEdt.getEditText().getText().toString();
            String userAnswer = userAnswerEdt.getEditText().getText().toString();

            // validating if the text fields are empty or not.
            if (userLogin.isEmpty() && userPassword.isEmpty() && userName.isEmpty() && userSurname.isEmpty() && userMiddleName.isEmpty() && userDateOfBirth.isEmpty() && userNumber.isEmpty() && userEmail.isEmpty()&& userQuestion.isEmpty() && userAnswer.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                return;
            }

            // on below line we are calling a method to add new
            // course to sqlite data and pass all our values to it.
            dbHandler.addNewUser(userLogin, userPassword, userName, userSurname, userMiddleName, userDateOfBirth, userNumber, userEmail, userQuestion, userAnswer);

            // after adding the data we are displaying a toast message.
            Toast.makeText(MainActivity.this, "User has been added.", Toast.LENGTH_SHORT).show();
            userLoginEdt.getEditText().setText("");
            userPasswordEdt.getEditText().setText("");
            userNameEdt.getEditText().setText("");
            userSurnameEdt.getEditText().setText("");
            userMiddleNameEdt.getEditText().setText("");
            userDateOfBirthEdt.getEditText().setText("");
            userEmailEdt.getEditText().setText("");
            userNumberEdt.getEditText().setText("");
            userQuestionEdt.getEditText().setText("");
            userAnswerEdt.getEditText().setText("");
        });
    }
}