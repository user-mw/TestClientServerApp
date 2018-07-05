package ru.workout.testclientserverapp.ui.first_screen;

import android.support.v7.widget.RecyclerView;

import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.testclientserverapp.databinding.ListItemBinding;

public class CarsViewHolder extends RecyclerView.ViewHolder {
    private ListItemBinding mHolderBinding;

    public CarsViewHolder(ListItemBinding binding) {
        super(binding.getRoot());
        mHolderBinding = binding;
    }

    public void bindData(ApiCar newCar, CarsAdapter.ICustomItemClickListener listener) {
        mHolderBinding.setCurrentViewModel(new CarsElementViewModel(newCar));
        mHolderBinding.setOnItemClickListener(listener);
        mHolderBinding.executePendingBindings();
    }
}
