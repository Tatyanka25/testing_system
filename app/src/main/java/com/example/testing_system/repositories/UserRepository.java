package com.example.testing_system.repositories;

import com.example.testing_system.dao.UserDao;
import com.example.testing_system.database.AppDatabase;
import com.example.testing_system.models.User;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    UserDao userDao;

    public UserRepository(AppDatabase appDatabase) {
        this.userDao = appDatabase.userDao();
    }
    public boolean checkIfUserWithEmailExists(String email) {
        return userDao.checkIfUserWithEmailExists(email);
    }

    public void insert(User user) {
        userDao.insert(user);
    }
}
