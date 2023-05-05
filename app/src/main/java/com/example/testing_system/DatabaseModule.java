package com.example.testing_system;

import android.content.Context;

import androidx.room.Room;

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
        return Room.databaseBuilder(context, AppDatabase.class, "testing_system").build();
    }
}