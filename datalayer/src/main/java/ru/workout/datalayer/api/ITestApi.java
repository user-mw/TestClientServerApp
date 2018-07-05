package ru.workout.datalayer.api;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;

public interface ITestApi {
    @GET("cars")
    Single<List<ApiCar>> getCars();

    @GET("cars/{id}")
    Single<ApiCar> getCarById(@Path("id") int id);
}
