package ru.workout.domainlayer.model.pojosforapi;

import com.google.gson.annotations.SerializedName;

import ru.workout.domainlayer.model.Car;

public class ApiCar {

    @SerializedName("id")
    private int mId;
    @SerializedName("brand")
    private String mBrand;
    @SerializedName("model")
    private String mModel;
    @SerializedName("year")
    private int mYear;
    @SerializedName("color")
    private String mColor;
    @SerializedName("cost")
    private String mCost;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getBrand() {
        return mBrand;
    }

    public void setBrand(String brand) {
        mBrand = brand;
    }

    public String getModel() {
        return mModel;
    }

    public void setModel(String model) {
        mModel = model;
    }

    public int getYear() {
        return mYear;
    }

    public void setYear(int year) {
        mYear = year;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getCost() {
        return mCost;
    }

    public void setCost(String cost) {
        mCost = cost;
    }

    public Car toDbCar() {
        Car dbCar = new Car();
        dbCar.setId(mId);
        dbCar.setBrand(mBrand);
        dbCar.setModel(mModel);
        dbCar.setYear(mYear);
        dbCar.setColor(mColor);
        dbCar.setCost(mCost);

        return dbCar;
    }
}
