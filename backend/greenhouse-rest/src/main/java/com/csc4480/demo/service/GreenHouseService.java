package com.csc4480.demo.service;

import com.csc4480.demo.model.Employee;
import com.csc4480.demo.model.Customer;
import com.csc4480.demo.model.Plant;

import com.csc4480.demo.repository.GreenHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class GreenHouseService {

    @Autowired
    private GreenHouseRepository greenHouseRepository;
    
    //when customer service is filled out
    public List<Customer> getGreenHouseCustomer() throws SQLException 
    {
        return greenHouseRepository.getCustomers();
    }

    public List<Employee> getAllGreenHouseEmployees() throws SQLException
    {
        return greenHouseRepository.getEmployeeInfo();
    }

    public List<Plant> getPlantTypeInfo() throws SQLException
    {
        return greenHouseRepository.getTypePriceDesc();
    }

    public List<Employee> getEmployeeW70Temp() throws SQLException
    {
        int temp = 70;
        return greenHouseRepository.getEmployeeWTemp(temp);
    }

    public List<Plant> getJJamesPlant() throws SQLException
    {
        String username = "JJam65";
        return greenHouseRepository.getPlantWUsername(username);
    }

    public List<Customer> getCustw2items10Price() throws SQLException
    {
        int itemQuantity = 1;
        int totalPrice = 10;
        return greenHouseRepository.getCustwithXPtemsXPrice(itemQuantity, totalPrice);
    }

    public List<Customer> getTop3Customers() 
    {
        int limitno = 3;
        return greenHouseRepository.getTopXCustomers(limitno);
    }

}
