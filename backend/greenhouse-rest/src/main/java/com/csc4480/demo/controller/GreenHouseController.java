package com.csc4480.demo.controller;

import com.csc4480.demo.model.Customer;
import com.csc4480.demo.model.Employee;
import com.csc4480.demo.model.Plant;

import com.csc4480.demo.service.GreenHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/greenHouse")
public class GreenHouseController {

    @Autowired
    private GreenHouseService greenHouseService;

    @GetMapping("/customers")
    public List<Customer> getGreenHouseCustomer() throws SQLException {
        return greenHouseService.getGreenHouseCustomer();
    }

    @GetMapping("/employees")
    public List<Employee> getAllGreenHouseEmployees() throws SQLException
    {
        return greenHouseService.getAllGreenHouseEmployees();
    }

    @GetMapping("/plant_info")
    public List<Plant> getPlantTypeInfo() throws SQLException
    {
        return greenHouseService.getPlantTypeInfo();
    }

    @GetMapping("/employee_and_degree")
    public List<Employee> getEmployeeW70Temp() throws SQLException
    {
        return greenHouseService.getEmployeeW70Temp();
    }

    @GetMapping("/JJamesPlant")
    public List<Employee> getJJamesPlant() throws SQLException
    {
        return greenHouseService.getEmployeeW70Temp();
    }

    @GetMapping("/sum_price_per_cust")
    public List<Customer> getCustw2items10Price() throws SQLException
    {
        return greenHouseService.getCustw2items10Price();
    }

    @GetMapping("/top_3_Customer")
    public List<Customer> getTop3Customers() 
    {
        return greenHouseService.getTop3Customers();
    }

}
