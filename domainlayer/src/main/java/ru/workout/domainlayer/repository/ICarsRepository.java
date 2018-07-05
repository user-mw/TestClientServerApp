package ru.workout.domainlayer.repository;

import java.util.List;

import io.reactivex.Single;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;

public interface ICarsRepository {

    String REMOTE = "Remote";
    String LOCAL = "Local";

    Single<List<ApiCar>> getCars();

    void insertCars(List<ApiCar> cars);

}
