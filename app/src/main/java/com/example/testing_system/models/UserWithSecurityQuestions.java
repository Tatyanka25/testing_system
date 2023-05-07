package com.example.testing_system.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithSecurityQuestions {
    @Embedded
    public User user;
    @Relation(parentColumn = "userId", entityColumn = "userId")
    public List<SecurityQuestionAnswer> answers;
}
