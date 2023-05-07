package com.example.testing_system.repositories;

import com.example.testing_system.dao.QuestionDao;
import com.example.testing_system.database.AppDatabase;
import javax.inject.Singleton;

@Singleton
public class QuestionRepository {
    private final QuestionDao dao;
    public QuestionRepository(AppDatabase appDatabase) {
        dao = appDatabase.questionDao();
    }
}