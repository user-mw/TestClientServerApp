package ru.workout.testclientserverapp.ui.first_screen;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.domainlayer.service.ICarsService;

public class FirstViewModel extends ViewModel {

    @Inject
    CarsAdapter.ICustomItemClickListener mListener;
    @Inject
    ICarsService mService;

    private ObservableArrayList<ApiCar> mCars = new ObservableArrayList<>();
    private ObservableBoolean mIsLoading = new ObservableBoolean(false);
    //private MutableLiveData<List<ApiCar>> mCars = new MutableLiveData<>();

    @Inject
    public FirstViewModel() {
    }

    public void loadCars() {
        mService.getCars()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mIsLoading.set(true))
                .doFinally(() -> mIsLoading.set(false))
                .subscribe(new SingleObserver<List<ru.workout.domainlayer.model.pojosforapi.ApiCar>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(List<ru.workout.domainlayer.model.pojosforapi.ApiCar> apiCars) {
                        if(mCars.size() > 0) {
                            mCars.clear();
                        }

                        mCars.addAll(apiCars);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public CarsAdapter.ICustomItemClickListener getListener() {
        return mListener;
    }

    public ObservableArrayList<ApiCar> getCars() {
        return mCars;
    }

    public ObservableBoolean getIsLoading() {
        return mIsLoading;
    }

//    public MutableLiveData<List<ApiCar>> getCars() {
//        return mCars;
//    }
}
