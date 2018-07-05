package ru.workout.domainlayer.repository;

import io.reactivex.Single;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;

public interface ISingleCarRepository {

    String REMOTE = "Remote";
    String LOCAL = "Local";

    Single<ApiCar> getCarById(int carId);

    void insertCar(ApiCar newCar);

}
