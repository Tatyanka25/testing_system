package com.example.testing_system.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.example.testing_system.dao.UserDao;
import com.example.testing_system.models.SecurityQuestion;
import com.example.testing_system.models.SecurityQuestionAnswer;
import com.example.testing_system.models.User;

@Database(entities = { User.class, SecurityQuestion.class, SecurityQuestionAnswer.class }, version = 1)
@TypeConverters({ DateConverter.class })
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
