package com.csc4480.demo.model;

public class Employee {
    private String firstName;
    private String mInit;
    private String lastName;
    private int employeeID;
    private int locationID;

    // constructor

    public Employee() {
    }

    public Employee(String firstName, String mInit, String lastName, int employeeID, int locationID) {
        this.firstName = firstName;
        this.mInit = mInit;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.locationID = locationID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getmInit() {
        return mInit;
    }

    public void setmInit(String mInit) {
        this.mInit = mInit;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
}