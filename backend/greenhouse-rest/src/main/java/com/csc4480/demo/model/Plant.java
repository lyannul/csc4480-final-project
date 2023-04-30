package com.csc4480.demo.model;

public class Plant {
    private int plantID;
    private int customerID;
    private String plantType;
    private int height;
    private int hydrated;
    private int sunlightStatus;

    // constructor

    public Plant() {
    }

    public Plant(int plantID, int customerID, String plantType, int height, int hydrated, int sunlightStatus) {
        this.plantID = plantID;
        this.customerID = customerID;
        this.plantType = plantType;
        this.height = height;
        this.hydrated = hydrated;
        this.sunlightStatus = sunlightStatus;
    }

    public int getPlantID() {
        return plantID;
    }

    public void setPlantID(int plantID) {
        this.plantID = plantID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHydrated() {
        return hydrated;
    }

    public void setHydrated(int hydrated) {
        this.hydrated = hydrated;
    }

    public int getSunlightStatus() {
        return sunlightStatus;
    }

    public void setSunlightStatus(int sunlightStatus) {
        this.sunlightStatus = sunlightStatus;
    }
}
