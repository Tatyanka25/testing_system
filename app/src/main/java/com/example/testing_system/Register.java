package com.example.testing_system;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class Register extends AppCompatActivity {
    EditText Login, Password, Name, Surname, MiddleName, DateOfBirth, Email, MobileNumber, Question, Answer ;
    Button Register;
    String LoginHolder, PasswordHolder, NameHolder, SurnameHolder, MiddleNameHolder, DateOfBirthHolder, EmailHolder, MobileNumberHolder,  QuestionHolder, AnswerHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    DBHandler sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_register);
        Login = (EditText)findViewById(R.id.idEdtuserLogin);
        Password = (EditText)findViewById(R.id.idEdtuserPassword);
        Name = (EditText)findViewById(R.id.idEdtuserName);
        Surname = (EditText)findViewById(R.id.idEdtuserSurname);
        MiddleName = (EditText)findViewById(R.id.idEdtuserMiddleName);
        DateOfBirth = (EditText)findViewById(R.id.idEdtuserDateOfBirth);
        Email = (EditText)findViewById(R.id.idEdtuserEmail);
        MobileNumber = (EditText)findViewById(R.id.idEdtuserNumber);
        Question = (EditText)findViewById(R.id.idEdtuserQuestion);
        Answer = (EditText)findViewById(R.id.idEdtuserAnswer);
        Register = (Button)findViewById(R.id.idBtnRegister);
        sqLiteHelper = new DBHandler(this);
        // Adding click listener to register button.
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();
                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();
                // Checking EditText is empty or Not.
                CheckEditTextStatus();
                // Method to check Email is already exists or not.
                CheckingEmailAlreadyExistsOrNot();
                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();
            }
        });
    }
    // SQLite database build method.
    public void SQLiteDataBaseBuild(){
        sqLiteDatabaseObj = openOrCreateDatabase(DBHandler.DB_NAME, Context.MODE_PRIVATE, null);
    }
    // SQLite table build method.
    public void SQLiteTableBuild() {
        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + DBHandler.TABLE_NAME + "(" + DBHandler.ID_COL + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + DBHandler.LOGIN_COL + " VARCHAR, " + DBHandler.PASSWORD_COL + " VARCHAR, " + DBHandler.NAME_COL + " VARCHAR," + DBHandler.SURNAME_COL + " VARCHAR, "+ DBHandler.MIDDLENAME_COL + " VARCHAR, "+ DBHandler.DATEOFBIRTH_COL + " VARCHAR, "+ DBHandler.EMAIL_COL + " VARCHAR, "+ DBHandler.NUMBER_COL + " VARCHAR, "+ DBHandler.QUESTION_COL + " VARCHAR, "+ DBHandler.ANSWER_COL + " VARCHAR);");
    }
    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase(){
        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {
            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+DBHandler.TABLE_NAME+" (login, password, name, surname, middle_name, date_of_birth, email, mobile_number, secret_question, answer) " +
                    "VALUES('"+LoginHolder+"', '"+PasswordHolder+"', '"+NameHolder+"', '"+SurnameHolder+"', '"+MiddleNameHolder+"', '"+DateOfBirthHolder+"', '"+EmailHolder+"', '"+MobileNumberHolder+"', '"+QuestionHolder+"', '"+AnswerHolder+"');";
            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);
            // Closing SQLite database object.
            sqLiteDatabaseObj.close();
            // Printing toast message after done inserting.
            Toast.makeText(Register.this,"User Registered Successfully", Toast.LENGTH_LONG).show();
        }
        // This block will execute if any of the registration EditText is empty.
        else {
            // Printing toast message if any of EditText is empty.
            Toast.makeText(Register.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();
        }
    }
    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){
        Login.getText().clear();
        Password.getText().clear();
        Name.getText().clear();
        Surname.getText().clear();
        MiddleName.getText().clear();
        DateOfBirth.getText().clear();
        Email.getText().clear();
        MobileNumber.getText().clear();
        Question.getText().clear();
        Answer.getText().clear();
    }
    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus(){
        // Getting value from All EditText and storing into String Variables.
        LoginHolder = Login.getText().toString() ;
        PasswordHolder = Password.getText().toString();
        NameHolder = Password.getText().toString();
        SurnameHolder = Password.getText().toString();
        MiddleNameHolder = Password.getText().toString();
        DateOfBirthHolder = Password.getText().toString();
        EmailHolder = Password.getText().toString();
        MobileNumberHolder = Password.getText().toString();
        QuestionHolder = Password.getText().toString();
        AnswerHolder = Password.getText().toString();
        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(PasswordHolder) || TextUtils.isEmpty(NameHolder)|| TextUtils.isEmpty(SurnameHolder)|| TextUtils.isEmpty(MiddleNameHolder)|| TextUtils.isEmpty(DateOfBirthHolder)|| TextUtils.isEmpty(EmailHolder)|| TextUtils.isEmpty(MobileNumberHolder)|| TextUtils.isEmpty(QuestionHolder)|| TextUtils.isEmpty(AnswerHolder)){
            EditTextEmptyHolder = false ;
        }
        else {
            EditTextEmptyHolder = true ;
        }
    }
    // Checking Email is already exists or not.
    public void CheckingEmailAlreadyExistsOrNot(){
        // Opening SQLite database write permission.
        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
        // Adding search email query to cursor.
        cursor = sqLiteDatabaseObj.query(DBHandler.TABLE_NAME, null, " " + DBHandler.EMAIL_COL + "=?", new String[]{EmailHolder}, null, null, null);
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                cursor.moveToFirst();
                // If Email is already exists then Result variable value set as Email Found.
                F_Result = "Email Found";
                // Closing cursor.
                cursor.close();
            }
        }
        // Calling method to check final result and insert data into SQLite database.
        CheckFinalResult();
    }
    // Checking result
    public void CheckFinalResult(){
        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {
            // If email is exists then toast msg will display.
            Toast.makeText(Register.this,"Email Already Exists",Toast.LENGTH_LONG).show();
        }
        else {
            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();
        }
        F_Result = "Not_Found" ;
    }
}