package com.example.testing_system.repositories;

import com.example.testing_system.dao.UserDao;
import com.example.testing_system.database.AppDatabase;
import com.example.testing_system.helpers.EncryptionHelper;
import com.example.testing_system.models.User;
import java.util.Objects;
import javax.inject.Singleton;

@Singleton
public class UserRepository {
    private final UserDao userDao;

    public UserRepository(AppDatabase appDatabase) {
        this.userDao = appDatabase.userDao();
    }
    public boolean checkIfUserWithEmailExists(String email) {
        return userDao.checkIfUserWithEmailExists(email);
    }

    public void insert(User user) {
        userDao.insert(user);
    }

    public boolean authenticate(String userName, String password) {
        String passwordHashFromDatabase = userDao.getPasswordByUserName(userName);
        return Objects.equals(passwordHashFromDatabase, EncryptionHelper.toSHA256String(password));
    }
}
