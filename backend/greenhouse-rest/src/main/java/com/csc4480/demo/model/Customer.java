package com.csc4480.demo.model;

public class Customer {
    private String firstName;
    private String mInit;
    private String lastName;
    private int customerID;
    private String userName;
    private String webPassword;

    // constructor

    public Customer() {
    }

    public Customer(String firstName, String mInit, String lastName, int customerID, String userName, String webPassword) {
        this.firstName = firstName;
        this.mInit = mInit;
        this.lastName = lastName;
        this.customerID = customerID;
        this.userName = userName;
        this.webPassword = webPassword;
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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWebPassword() {
        return webPassword;
    }

    public void setWebPassword(String webPassword) {
        this.webPassword = webPassword;
    }
}