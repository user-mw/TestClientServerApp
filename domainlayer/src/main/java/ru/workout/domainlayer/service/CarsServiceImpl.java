package ru.workout.domainlayer.service;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.repository.ICarsRepository;

public class CarsServiceImpl implements ICarsService {

    @Inject
    @Named(ICarsRepository.REMOTE)
    ICarsRepository mServerRepository;

    @Inject
    @Named(ICarsRepository.LOCAL)
    ICarsRepository mDbRepository;

    @Inject
    public CarsServiceImpl() {

    }

    @Override
    public Single<List<ApiCar>> getCars() {
        return mServerRepository.getCars().subscribeOn(Schedulers.io())
                .doOnSuccess(response -> {
                    mDbRepository.insertCars(response);
                })
                .onErrorReturn(throwable -> mDbRepository.getCars().blockingGet());
    }

    @Override
    public void insertCars(List<ApiCar> cars) {
        mDbRepository.insertCars(cars);
    }
}
