package ru.workout.domainlayer.service;

import java.util.List;

import io.reactivex.Single;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;

public interface ICarsService {
    Single<List<ApiCar>> getCars();

    void insertCars(List<ApiCar> cars);
}
