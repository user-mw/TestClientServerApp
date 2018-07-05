package ru.workout.datalayer.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.workout.domainlayer.model.Car;

@Dao
public interface ITestDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCar(Car newCar);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCars(List<Car> cars);

    @Query("SELECT * FROM car")
    List<Car> getCars();

    @Query("SELECT * FROM car WHERE id=:carId")
    Car getCarById(int carId);
}
