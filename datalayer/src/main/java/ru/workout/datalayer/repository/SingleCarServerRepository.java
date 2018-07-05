package ru.workout.datalayer.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.workout.datalayer.api.ITestApi;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.repository.ISingleCarRepository;

public class SingleCarServerRepository implements ISingleCarRepository {
    @Inject
    ITestApi mApi;

    @Inject
    public SingleCarServerRepository() {

    }

    @Override
    public Single<ApiCar> getCarById(int carId) {
        return mApi.getCarById(carId);
    }

    @Override
    public void insertCar(ApiCar newCar) {
        // it is not server feature
    }
}
