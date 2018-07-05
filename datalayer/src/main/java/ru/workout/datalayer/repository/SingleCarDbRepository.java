package ru.workout.datalayer.repository;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.functions.Function;
import ru.workout.datalayer.database.ITestDao;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.repository.ISingleCarRepository;

public class SingleCarDbRepository implements ISingleCarRepository {
    @Inject
    ITestDao mDao;

    @Inject
    public SingleCarDbRepository() {

    }

    @Override
    public Single<ApiCar> getCarById(int carId) {
        return Single.fromCallable(() -> mDao.getCarById(carId).toApiCar());
    }

    @Override
    public void insertCar(ApiCar newCar) {
        mDao.insertCar(newCar.toDbCar());
    }
}
