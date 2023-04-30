package com.csc4480.demo.model;

public class PlantType {
    private String typeName;
    private String description;
    private int price;
    private String color;
    private int locationID;
    private String waterNeeds;
    private String soilType;

    // constructor


    public PlantType() {
    }

    public PlantType(String typeName, String description, int price, String color, int locationID, String waterNeeds, String soilType) {
        this.typeName = typeName;
        this.description = description;
        this.price = price;
        this.color = color;
        this.locationID = locationID;
        this.waterNeeds = waterNeeds;
        this.soilType = soilType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public String getWaterNeeds() {
        return waterNeeds;
    }

    public void setWaterNeeds(String waterNeeds) {
        this.waterNeeds = waterNeeds;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }
}