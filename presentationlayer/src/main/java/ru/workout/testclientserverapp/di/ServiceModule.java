package ru.workout.testclientserverapp.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.workout.domainlayer.service.CarsServiceImpl;
import ru.workout.domainlayer.service.ICarsService;
import ru.workout.domainlayer.service.ISingleCarService;
import ru.workout.domainlayer.service.SingleCarServiceImpl;

@Module
public class ServiceModule {
    @Provides
    @IFragmentScope
    ICarsService provideCarsService(CarsServiceImpl service) {
        return service;
    }

    @Provides
    @IFragmentScope
    ISingleCarService provideSingleCarService(SingleCarServiceImpl service) {
        return service;
    }
}
