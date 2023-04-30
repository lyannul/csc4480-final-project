package com.csc4480.demo.model;

public class NumberOf {
    private String plantType;
    private int locationID;
    private int quantity;

    // constructor


    public NumberOf() {
    }

    public NumberOf(String plantType, int locationID, int quantity) {
        this.plantType = plantType;
        this.locationID = locationID;
        this.quantity = quantity;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
