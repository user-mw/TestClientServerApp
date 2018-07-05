package ru.workout.testclientserverapp.di;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.workout.datalayer.repository.CarsDbRepository;
import ru.workout.datalayer.repository.CarsServerRepository;
import ru.workout.datalayer.repository.SingleCarDbRepository;
import ru.workout.datalayer.repository.SingleCarServerRepository;
import ru.workout.domainlayer.repository.ICarsRepository;
import ru.workout.domainlayer.repository.ISingleCarRepository;

@Module
public class RepositoryModule {

    @Provides
    @IFragmentScope
    @Named(ICarsRepository.REMOTE)
    ICarsRepository provideCarsServerRepository(CarsServerRepository repository) {
        return repository;
    }

    @Provides
    @IFragmentScope
    @Named(ICarsRepository.LOCAL)
    ICarsRepository provideCarsDbRepository(CarsDbRepository repository) {
        return repository;
    }

    @Provides
    @IFragmentScope
    @Named(ISingleCarRepository.REMOTE)
    ISingleCarRepository provideSingleCarServerRepository(SingleCarServerRepository repository) {
        return repository;
    }

    @Provides
    @IFragmentScope
    @Named(ISingleCarRepository.LOCAL)
    ISingleCarRepository provideSingleCarDbRepository(SingleCarDbRepository repository) {
        return repository;
    }
}
