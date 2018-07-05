package ru.workout.testclientserverapp.ui.second_screen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import ru.workout.testclientserverapp.MainApplication;
import ru.workout.testclientserverapp.databinding.SecondBinding;
import ru.workout.testclientserverapp.di.NetworkModule;
import ru.workout.testclientserverapp.di.RepositoryModule;
import ru.workout.testclientserverapp.di.ServiceModule;
import ru.workout.testclientserverapp.ui.BaseFragment;

public class SecondFragment extends BaseFragment {

    @Inject
    SecondViewModel mViewModel;

    private static String CAR_ID = "CarId";

    public static SecondFragment newInstance(int carId) {
        Bundle args = new Bundle();
        args.putInt(CAR_ID, carId);
        
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainApplication.getApplicationComponent().plusSecondScreenComponent(new RepositoryModule(), new ServiceModule())
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SecondBinding binding = SecondBinding.inflate(inflater, container, false);
        binding.setCurrentViewModel(mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getArguments() != null) {
            int carId = getArguments().getInt(CAR_ID);
            mViewModel.loadCar(carId);
        }

    }
}
