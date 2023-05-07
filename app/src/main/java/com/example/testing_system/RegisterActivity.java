package com.example.testing_system;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testing_system.models.User;
import com.example.testing_system.repositories.UserRepository;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Date;
import javax.inject.Inject;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class RegisterActivity extends AppCompatActivity {
    @Inject
    UserRepository repository;
    TextInputLayout Login, Password, Name, Surname, MiddleName, DateOfBirth, Email, MobileNumber, Question, Answer ;
    Button Register;
    String LoginHolder, PasswordHolder, NameHolder, SurnameHolder, MiddleNameHolder, DateOfBirthHolder, EmailHolder, MobileNumberHolder,  QuestionHolder, AnswerHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Login = findViewById(R.id.idEdtuserLogin);
        Password = findViewById(R.id.idEdtuserPassword);
        Name = findViewById(R.id.idEdtuserName);
        Surname = findViewById(R.id.idEdtuserSurname);
        MiddleName = findViewById(R.id.idEdtuserMiddleName);
        DateOfBirth = findViewById(R.id.idEdtuserDateOfBirth);
        Email = findViewById(R.id.idEdtuserEmail);
        MobileNumber = findViewById(R.id.idEdtuserNumber);
        Question = findViewById(R.id.idEdtuserQuestion);
        Answer = findViewById(R.id.idEdtuserAnswer);
        Register = findViewById(R.id.idBtnRegister);
        Register.setOnClickListener(view -> {
            MoveToLocalStrings();
            if (!Validate()) return;
            if (repository.checkIfUserWithEmailExists(Email.getEditText().getText().toString()))
                return;
            User user = new User(LoginHolder, PasswordHolder, NameHolder, MiddleNameHolder,
                    SurnameHolder, EmailHolder, MobileNumberHolder, new Date(1000));
            repository.insert(user);
            EmptyEditTextAfterDataInsert();
        });
    }

    private void MoveToLocalStrings() {
        LoginHolder = Login.getEditText().getText().toString() ;
        PasswordHolder = Password.getEditText().getText().toString();
        NameHolder = Name.getEditText().getText().toString();
        SurnameHolder = Surname.getEditText().getText().toString();
        MiddleNameHolder = MiddleName.getEditText().getText().toString();
        DateOfBirthHolder = DateOfBirth.getEditText().getText().toString();
        EmailHolder = Email.getEditText().getText().toString();
        MobileNumberHolder = MobileNumber.getEditText().getText().toString();
        QuestionHolder = Question.getEditText().getText().toString();
        AnswerHolder = Answer.getEditText().getText().toString();
    }

    public void EmptyEditTextAfterDataInsert(){
        Login.getEditText().getText().clear();
        Password.getEditText().getText().clear();
        Name.getEditText().getText().clear();
        Surname.getEditText().getText().clear();
        MiddleName.getEditText().getText().clear();
        DateOfBirth.getEditText().getText().clear();
        Email.getEditText().getText().clear();
        MobileNumber.getEditText().getText().clear();
        Question.getEditText().getText().clear();
        Answer.getEditText().getText().clear();
    }

    public boolean Validate(){
        return !TextUtils.isEmpty(LoginHolder) &&
               !TextUtils.isEmpty(PasswordHolder) &&
               !TextUtils.isEmpty(NameHolder) &&
               !TextUtils.isEmpty(SurnameHolder) &&
               !TextUtils.isEmpty(MiddleNameHolder) &&
               !TextUtils.isEmpty(DateOfBirthHolder) &&
               !TextUtils.isEmpty(EmailHolder) &&
               !TextUtils.isEmpty(MobileNumberHolder) &&
               !TextUtils.isEmpty(QuestionHolder) &&
               !TextUtils.isEmpty(AnswerHolder);
    }

    public void RedirectToLogin(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }
}