package ru.workout.testclientserverapp.ui.second_screen;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.service.ISingleCarService;

public class SecondViewModel {

    @Inject
    ISingleCarService mService;

    private ObservableField<String> mCarBrand = new ObservableField<>();
    private ObservableField<String> mCarModel = new ObservableField<>();
    private ObservableField<String> mCarYear = new ObservableField<>();
    private ObservableField<String> mCarColor = new ObservableField<>();
    private ObservableField<String> mCarCost = new ObservableField<>();
    private ObservableBoolean mIsError = new ObservableBoolean(false);

    @Inject
    public SecondViewModel() {

    }

    public void loadCar(int carId) {
        mService.getCarById(carId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ApiCar>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(ApiCar apiCar) {
                        mIsError.set(false);

                        mCarBrand.set(apiCar.getBrand());
                        mCarModel.set(apiCar.getModel());
                        mCarYear.set(String.valueOf(apiCar.getYear()));
                        mCarColor.set(apiCar.getColor());
                        mCarCost.set(apiCar.getCost());
                    }

                    @Override
                    public void onError(Throwable e) {
                        mIsError.set(true);
                    }
                });
    }

    public ObservableField<String> getCarBrand() {
        return mCarBrand;
    }

    public ObservableField<String> getCarModel() {
        return mCarModel;
    }

    public ObservableField<String> getCarYear() {
        return mCarYear;
    }

    public ObservableField<String> getCarColor() {
        return mCarColor;
    }

    public ObservableField<String> getCarCost() {
        return mCarCost;
    }

    public ObservableBoolean getIsError() {
        return mIsError;
    }
}
