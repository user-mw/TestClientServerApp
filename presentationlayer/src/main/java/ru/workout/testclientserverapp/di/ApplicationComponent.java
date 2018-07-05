package ru.workout.testclientserverapp.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DatabaseModule.class, NetworkModule.class})
public interface ApplicationComponent {
    IFirstScreenComponent plusFirstScreenComponent(FirstScreenModule moduleOne, RepositoryModule repository, ServiceModule service);
    ISecondScreenComponent plusSecondScreenComponent(RepositoryModule repository, ServiceModule service);
}
