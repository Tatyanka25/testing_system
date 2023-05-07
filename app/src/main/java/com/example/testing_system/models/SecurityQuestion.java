package com.example.testing_system.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SecurityQuestion {
    @PrimaryKey
    public long questionId;
    public String question;
}
