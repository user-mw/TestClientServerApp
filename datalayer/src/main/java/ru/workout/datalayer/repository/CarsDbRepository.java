package ru.workout.datalayer.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Single;
import ru.workout.datalayer.database.ITestDao;
import ru.workout.domainlayer.model.Car;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.repository.ICarsRepository;

public class CarsDbRepository implements ICarsRepository {
    @Inject
    ITestDao mDao;

    @Inject
    public CarsDbRepository() {

    }

    @Override
    public Single<List<ApiCar>> getCars() {
        return Single.fromCallable(new Callable<List<ApiCar>>() {
            @Override
            public List<ApiCar> call() throws Exception {
                List<Car> cars = mDao.getCars();
                List<ApiCar> apiCars = new ArrayList<>();

                for(int step = 0; step < cars.size(); step++) {
                    apiCars.add(cars.get(step).toApiCar());
                }

                return apiCars;
            }
        });
    }

    @Override
    public void insertCars(List<ApiCar> cars) {
        List<Car> simpleCars = new ArrayList<>();

        for(int step = 0; step < cars.size(); step++) {
            simpleCars.add(cars.get(step).toDbCar());
        }

        mDao.insertCars(simpleCars);
    }
}
