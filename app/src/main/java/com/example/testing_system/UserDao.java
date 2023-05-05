package com.example.testing_system;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id = :id")
    User getById(int id);

    @Insert
    void insert(User user);

    @Query("SELECT CAST(CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS BIT) FROM user WHERE email = :email;")
    boolean checkIfUserWithEmailExists(String email);
}
