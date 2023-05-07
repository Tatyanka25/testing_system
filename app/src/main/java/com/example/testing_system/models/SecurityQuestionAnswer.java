package com.example.testing_system.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SecurityQuestionAnswer {
    @PrimaryKey
    public long answerId;

    public long userId;

    public String question;
    public String answer;
}
