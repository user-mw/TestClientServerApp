package ru.workout.testclientserverapp.ui.first_screen;

import ru.workout.domainlayer.model.pojosforapi.ApiCar;

public class CarsElementViewModel {
    private String mCarName;
    private String mCarCost;
    private int mCarId;

    public CarsElementViewModel(ApiCar newCar) {
        mCarName = newCar.getBrand() + " " + newCar.getModel();
        mCarCost = newCar.getCost();
        mCarId = newCar.getId();
    }

    public String getCarName() {
        return mCarName;
    }

    public String getCarCost() {
        return mCarCost;
    }

    public int getCarId() {
        return mCarId;
    }
}
