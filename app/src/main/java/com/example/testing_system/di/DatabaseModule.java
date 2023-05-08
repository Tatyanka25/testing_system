package com.example.testing_system.di;

import android.content.Context;

import androidx.room.Room;
import com.example.testing_system.database.AppDatabase;
import com.example.testing_system.models.SecurityQuestion;
import com.example.testing_system.repositories.QuestionRepository;
import com.example.testing_system.repositories.SecurityQuestionRepository;
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
        AppDatabase db = Room
                .databaseBuilder(context, AppDatabase.class, "testing_system")
                .allowMainThreadQueries()
                .build();
        if (!db.securityQuestionDao().any()) prepopulate(db);
        return db;
    }

    private static void prepopulate(AppDatabase db) {
        db.securityQuestionDao().insert(
                new SecurityQuestion("Option 1"),
                new SecurityQuestion("Option 2"),
                new SecurityQuestion("Option 3")
        );
    }

    @Provides
    public static UserRepository provideUserRepository(AppDatabase appDatabase) {
        return new UserRepository(appDatabase);
    }

    @Provides
    public static QuestionRepository provideQuestionRepository(AppDatabase appDatabase) {
        return new QuestionRepository(appDatabase);
    }

    @Provides
    public static SecurityQuestionRepository provideSecurityQuestionRepository(AppDatabase appDatabase) {
        return new SecurityQuestionRepository(appDatabase);
    }
}