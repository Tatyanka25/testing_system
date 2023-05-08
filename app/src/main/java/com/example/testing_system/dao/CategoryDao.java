package com.example.testing_system.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import com.example.testing_system.models.Category;

@Dao
public interface CategoryDao {
    @Insert
    void insert(Category... questions);
}
