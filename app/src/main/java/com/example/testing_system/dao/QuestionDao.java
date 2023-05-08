package com.example.testing_system.dao;

import androidx.room.Dao;
import androidx.room.Insert;

import com.example.testing_system.models.Question;

@Dao
public interface QuestionDao {
    @Insert
    void insert(Question... questions);
}
