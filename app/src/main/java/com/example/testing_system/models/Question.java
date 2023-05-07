package com.example.testing_system.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class Question {
    public User(String userName, String passwordHash, String firstName, String middleName, String lastName, String email, String mobileNumber, Date dateOfBirth) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.dateOfBirth = dateOfBirth;
    }

    @PrimaryKey
    public int userId;

    @ColumnInfo(name = "userName")
    public String userName;

    @ColumnInfo(name = "passwordHash")
    public String passwordHash;

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
}
