package com.example.testing_system;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText userLoginEdt, userPasswordEdt, userNameEdt, userSurnameEdt, userMiddleNameEdt, userDateOfBirthEdt, userEmailEdt, userNumberEdt, userQuestionEdt, userAnswerEdt;
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
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String userLogin = userLoginEdt.getText().toString();
                String userPassword = userPasswordEdt.getText().toString();
                String userName = userNameEdt.getText().toString();
                String userSurname = userSurnameEdt.getText().toString();
                String userMiddleName = userMiddleNameEdt.getText().toString();
                String userDateOfBirth = userDateOfBirthEdt.getText().toString();
                String userEmail = userEmailEdt.getText().toString();
                String userNumber = userNumberEdt.getText().toString();
                String userQuestion = userQuestionEdt.getText().toString();
                String userAnswer = userAnswerEdt.getText().toString();

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
                userLoginEdt.setText("");
                userPasswordEdt.setText("");
                userNameEdt.setText("");
                userSurnameEdt.setText("");
                userMiddleNameEdt.setText("");
                userDateOfBirthEdt.setText("");
                userEmailEdt.setText("");
                userNumberEdt.setText("");
                userQuestionEdt.setText("");
                userAnswerEdt.setText("");
            }
        });
    }
}