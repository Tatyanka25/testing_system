package com.example.testing_system.di;

import android.content.Context;

import androidx.room.Room;

import com.example.testing_system.database.AppDatabase;
import com.example.testing_system.repositories.UserRepository;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ApplicationContext;

@Module
@InstallIn(ActivityComponent.class)
public class DatabaseModule {
    @Provides
    public static AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return Room
                .databaseBuilder(context, AppDatabase.class, "testing_system")
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    public static UserRepository provideUserRepository(AppDatabase appDatabase) {
        return new UserRepository(appDatabase);
    }
}