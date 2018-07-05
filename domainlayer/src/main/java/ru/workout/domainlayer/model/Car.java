package ru.workout.domainlayer.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import ru.workout.domainlayer.model.pojosforapi.ApiCar;

@Entity
public class Car {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int mId;
    @ColumnInfo(name = "brand")
    private String mBrand;
    @ColumnInfo(name = "model")
    private String mModel;
    @ColumnInfo(name = "year")
    private int mYear;
    @ColumnInfo(name = "color")
    private String mColor;
    @ColumnInfo(name = "cost")
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

    public ApiCar toApiCar() {
        ApiCar apiCar = new ApiCar();
        apiCar.setId(mId);
        apiCar.setBrand(mBrand);
        apiCar.setModel(mModel);
        apiCar.setYear(mYear);
        apiCar.setColor(mColor);
        apiCar.setCost(mCost);

        return apiCar;
    }
}
