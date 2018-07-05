package ru.workout.testclientserverapp.ui.first_screen;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.workout.domainlayer.model.pojosforapi.ApiCar;
import ru.workout.testclientserverapp.databinding.ListItemBinding;

public class CarsAdapter extends RecyclerView.Adapter<CarsViewHolder> {

    @NonNull
    private final List<ApiCar> mCars;
    private final ICustomItemClickListener mListener;

    public CarsAdapter(List<ApiCar> carsList, ICustomItemClickListener listener) {
        mCars = carsList;
        mListener = listener;
    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ListItemBinding binding = ListItemBinding.inflate(inflater, parent, false);
        return new CarsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        ApiCar currentCar = mCars.get(position);
        holder.bindData(currentCar, mListener);
    }

    @Override
    public int getItemCount() {
        if(mCars == null) {
            return 0;
        }
        return mCars.size();
    }

    public interface ICustomItemClickListener {
        void onClick(int carId);
    }
}
