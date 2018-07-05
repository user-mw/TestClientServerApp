package ru.workout.testclientserverapp.utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.testclientserverapp.ui.first_screen.CarsAdapter;

public class CustomBindingAdapter {
    @BindingAdapter({"bind:data", "bind:itemClickListener"})
    public static void configureRecyclerView(RecyclerView recyclerView, List<ApiCar> carsList, CarsAdapter.ICustomItemClickListener listener) {
        CarsAdapter adapter = new CarsAdapter(carsList, listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(adapter);
    }
}
