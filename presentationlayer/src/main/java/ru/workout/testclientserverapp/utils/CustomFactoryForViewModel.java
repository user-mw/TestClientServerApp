package ru.workout.testclientserverapp.utils;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import ru.workout.datalayer.database.ITestDao;
import ru.workout.testclientserverapp.ui.first_screen.CarsAdapter;
import ru.workout.testclientserverapp.ui.first_screen.FirstViewModel;

// toDo: For now this class is not using. But it is possible that it can be needed.

public class CustomFactoryForViewModel extends ViewModelProvider.NewInstanceFactory {

    private CarsAdapter.ICustomItemClickListener mListener;
    private ITestDao mDao;

    public CustomFactoryForViewModel(CarsAdapter.ICustomItemClickListener listener, ITestDao dao) {
        mListener = listener;
        mDao = dao;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //return (T) new FirstViewModel(mListener, mDao); // for DI
        return (T) new FirstViewModel();
    }
}
