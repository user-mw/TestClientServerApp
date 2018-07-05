package ru.workout.domainlayer.service;

import io.reactivex.Single;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;

public interface ISingleCarService {
    Single<ApiCar> getCarById(int carId);

    void insertCar(ApiCar newCar);
}
