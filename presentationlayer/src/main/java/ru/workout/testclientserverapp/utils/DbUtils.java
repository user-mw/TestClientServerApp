package ru.workout.testclientserverapp.utils;

import android.arch.persistence.room.Room;
import android.content.Context;

import ru.workout.datalayer.database.ITestDao;
import ru.workout.datalayer.database.TestDatabase;

// toDo: This class is not using anymore. Just to remind how it was before.

public class DbUtils {
    private static TestDatabase getDatabase(Context context) {
        return Room.databaseBuilder(context, TestDatabase.class, "testing_database").build();
    }

    public static ITestDao getDao(Context context) {
        return getDatabase(context).getDao();
    }
}
