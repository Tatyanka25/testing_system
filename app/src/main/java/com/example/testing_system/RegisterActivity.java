package com.example.testing_system;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.testing_system.helpers.EncryptionHelper;
import com.example.testing_system.models.User;
import com.example.testing_system.repositories.UserRepository;
import com.google.android.material.snackbar.Snackbar;
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
        Login = findViewById(R.id.idEditUserName);
        Password = findViewById(R.id.idEditPassword);
        Name = findViewById(R.id.idEditName);
        Surname = findViewById(R.id.idEditSurname);
        MiddleName = findViewById(R.id.idEditMiddleName);
        DateOfBirth = findViewById(R.id.idEditDateOfBirth);
        Email = findViewById(R.id.idEditEmail);
        MobileNumber = findViewById(R.id.idEditPhoneNumber);
        Question = findViewById(R.id.idEditSecurityQuestion);
        Answer = findViewById(R.id.idEditQuestionAnswer);
        Register = findViewById(R.id.idBtnRegister);
        Register.setOnClickListener(view -> {
            MoveToLocalStrings();
            if (!Validate()) {
                Snackbar.make(view, R.string.validation_error, Snackbar.LENGTH_SHORT).show();
                return;
            }
            if (repository.checkIfUserWithEmailExists(Email.getEditText().getText().toString())) {
                Snackbar.make(view, R.string.email_already_exists, Snackbar.LENGTH_SHORT).show();
                return;
            }
            User user = new User(LoginHolder, EncryptionHelper.toSHA256String(PasswordHolder), NameHolder, MiddleNameHolder,
                    SurnameHolder, EmailHolder, MobileNumberHolder, new Date(1000));
            repository.insert(user);
            Snackbar.make(view, R.string.reg_success, Snackbar.LENGTH_SHORT).show();
            finish();
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