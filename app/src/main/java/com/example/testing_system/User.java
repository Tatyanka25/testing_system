package com.example.testing_system;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class User {
    public User(String login, String password, String firstName, String middleName, String lastName, String email, String mobileNumber, Date dateOfBirth) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public User(String loginHolder, String passwordHolder, String nameHolder, String middleNameHolder, String surnameHolder, String emailHolder, String mobileNumberHolder, Date date, String questionHolder, String answerHolder) {}

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "login")
    public String login;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "first_name")
    public String firstName;

    @ColumnInfo(name = "middle_name")
    public String middleName;

    @ColumnInfo(name = "last_name")
    public String lastName;

    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "mobile_number")
    public String mobileNumber;

    @ColumnInfo(name = "date_of_birth")
    public Date dateOfBirth;

    public static final String QUESTION_COL = "secret_question";
    public static final String ANSWER_COL = "answer";
}
