package ru.workout.datalayer.repository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.workout.datalayer.api.ITestApi;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.repository.ICarsRepository;

public class CarsServerRepository implements ICarsRepository {
    @Inject
    ITestApi mApi;

    @Inject
    public CarsServerRepository() {

    }

    @Override
    public Single<List<ApiCar>> getCars() {
        return mApi.getCars();
    }

    @Override
    public void insertCars(List<ApiCar> cars) {
        // it is not server feature
    }
}
