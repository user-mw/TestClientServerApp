package ru.workout.testclientserverapp.di;

import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.workout.datalayer.database.ITestDao;
import ru.workout.datalayer.database.TestDatabase;
import ru.workout.testclientserverapp.MainApplication;

@Module
public class DatabaseModule {
    private MainApplication mApplicationInstance;

    public DatabaseModule(MainApplication applicationInstance) {
        mApplicationInstance = applicationInstance;
    }

    @Provides
    @Singleton
    public TestDatabase provideDatabase() {
        return Room.databaseBuilder(mApplicationInstance, TestDatabase.class, "testing_database")
                .build();
    }

    @Provides
    @Singleton
    public ITestDao provideDao(TestDatabase db) {
        return db.getDao();
    }
}
