package ru.workout.testclientserverapp.di;

import dagger.Module;
import dagger.Provides;
import ru.workout.testclientserverapp.ui.first_screen.CarsAdapter;

@Module
public class FirstScreenModule {
    private CarsAdapter.ICustomItemClickListener mListener;

    public FirstScreenModule(CarsAdapter.ICustomItemClickListener newListener) {
        mListener = newListener;
    }

    @Provides
    @IFragmentScope
    CarsAdapter.ICustomItemClickListener provideListener() {
        return mListener;
    }

}
