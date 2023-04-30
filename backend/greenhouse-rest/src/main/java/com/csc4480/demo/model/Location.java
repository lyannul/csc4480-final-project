package com.csc4480.demo.model;

public class Location {
    private int locationID;
    private String locationSector;
    private int humidity;
    private int temperature;

    // constructor


    public Location() {
    }

    public Location(int locationID, String locationSector, int humidity, int temperature) {
        this.locationID = locationID;
        this.locationSector = locationSector;
        this.humidity = humidity;
        this.temperature = temperature;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getLocationSector() {
        return locationSector;
    }

    public void setLocationSector(String locationSector) {
        this.locationSector = locationSector;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}