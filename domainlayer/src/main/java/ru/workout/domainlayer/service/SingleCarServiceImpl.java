package ru.workout.domainlayer.service;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.repository.ISingleCarRepository;

public class SingleCarServiceImpl implements ISingleCarService {

    @Inject
    @Named(ISingleCarRepository.REMOTE)
    ISingleCarRepository mServerRepository;

    @Inject
    @Named(ISingleCarRepository.LOCAL)
    ISingleCarRepository mDbRepository;

    @Inject
    public SingleCarServiceImpl() {

    }

    @Override
    public Single<ApiCar> getCarById(int carId) {
        return mServerRepository.getCarById(carId)
                .subscribeOn(Schedulers.io())
                .doOnSuccess(response -> mDbRepository.insertCar(response))
                .onErrorReturn(throwable -> mDbRepository.getCarById(carId).blockingGet());
    }

    @Override
    public void insertCar(ApiCar newCar) {
        mDbRepository.insertCar(newCar);
    }
}
