package ru.workout.testclientserverapp.ui.first_screen;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import ru.workout.testclientserverapp.MainApplication;
import ru.workout.testclientserverapp.databinding.FirstBinding;
import ru.workout.testclientserverapp.di.FirstScreenModule;
import ru.workout.testclientserverapp.di.RepositoryModule;
import ru.workout.testclientserverapp.di.ServiceModule;
import ru.workout.testclientserverapp.ui.BaseFragment;
import ru.workout.testclientserverapp.ui.second_screen.SecondFragment;

public class FirstFragment extends BaseFragment {

    private CarsAdapter.ICustomItemClickListener mClickListener =
            carId -> changeFragment(SecondFragment.newInstance(carId));

    @Inject
    FirstViewModel mViewModel;

    public static FirstFragment newInstance() {
        Bundle args = new Bundle();
        
        FirstFragment fragment = new FirstFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        CustomFactoryForViewModel factory = new CustomFactoryForViewModel(mClickListener, dao);
//        mViewModel = ViewModelProviders.of(this, factory).get(FirstViewModel.class);
        MainApplication.getApplicationComponent()
                .plusFirstScreenComponent(new FirstScreenModule(mClickListener), new RepositoryModule(), new ServiceModule())
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FirstBinding currentBinding = FirstBinding.inflate(inflater, container, false);
        currentBinding.setCurrentViewModel(mViewModel);
        //currentBinding.setLifecycleOwner(this);
        return currentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel.loadCars();
    }
}
