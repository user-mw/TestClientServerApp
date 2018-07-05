package ru.workout.datalayer.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.workout.domainlayer.model.Car;

@Database(entities = {Car.class}, version = 1)
public abstract class TestDatabase extends RoomDatabase {
    public abstract ITestDao getDao();
}
