package ru.workout.testclientserverapp;

import android.app.Application;

import ru.workout.testclientserverapp.di.ApplicationComponent;
import ru.workout.testclientserverapp.di.DaggerApplicationComponent;
import ru.workout.testclientserverapp.di.DatabaseModule;
import ru.workout.testclientserverapp.di.NetworkModule;

public class MainApplication extends Application {
    private static ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .databaseModule(new DatabaseModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
