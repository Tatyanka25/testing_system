package com.example.testing_system.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SecurityQuestion {
    public SecurityQuestion(String question) {
        this.question = question;
    }

    @PrimaryKey(autoGenerate = true)
    public long questionId;
    public String question;
}
