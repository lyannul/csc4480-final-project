package com.csc4480.demo.repository;
import com.csc4480.demo.model.Customer;
import com.csc4480.demo.model.Employee;
import com.csc4480.demo.model.Plant;
import com.csc4480.demo.model.PlantType;
import com.csc4480.demo.model.NumberOf;
import com.csc4480.demo.repository.CustomerRepository.CustomerRowMapper;
import com.csc4480.demo.repository.EmployeeRepository.EmployeeRowMapper;
import com.csc4480.demo.repository.PlantRepository.PlantRowMapper;
import com.csc4480.demo.repository.PlantTypeRepository.PlantTypeRowMapper;
import com.csc4480.demo.repository.NumberOfRepository.NumberOfRowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GreenHouseRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Customer> getCustomers() {
        String query = "SELECT FirstName, LastName, UserName FROM CUSTOMER";
        return jdbcTemplate.query(query, new CustomerRowMapper());
    }

    public List<Employee> getEmployeeInfo() {
        String query = "SELECT FirstName, LastName, LocationID FROM EMPLOYEE";
        return jdbcTemplate.query(query, new EmployeeRowMapper());
    }

    public List<PlantType> getTypePriceDesc() {
        String query = "SELECT TypeName, Description, Price FROM PLANT_TYPE";
        return jdbcTemplate.query(query, new PlantTypeRowMapper());
    }

    public List<NumberOf> getInvforAllPlantTypes() {
        String query = "SELECT TypeName, LocationSector, Quantity FROM NUMBER_OF JOIN LOCATION ON NUMBER_OF.LocationID = LOCATION.LocationID";
        return jdbcTemplate.query(query, new NumberOfRowMapper());
    }

    public List<Employee> getEmployeeWTemp(int temp) {
        String query = "SELECT EMPLOYEE.FirstName, EMPLOYEE.LastName, LOCATION.LocationSector FROM EMPLOYEE JOIN LOCATION ON EMPLOYEE.LocationID = LOCATION.LocationID WHERE LOCATION.Temperature >= ?";
        Object[] args = { temp };
        return jdbcTemplate.query(query, new EmployeeRowMapper(), args);
    }

    public List<Plant> getPlantWUsername(String username) {
        String query = "SELECT PLANT.PlantID, PLANT.PlantType, CUSTOMER.UserName FROM PLANT JOIN CUSTOMER ON PLANT.CustomerID = CUSTOMER.CustomerID WHERE CUSTOMER.UserName = ?";
        Object[] args = { username };
        return jdbcTemplate.query(query, new PlantRowMapper(), args);
    }

    public List<Customer> getCustwithXPtemsXPrice(int itemQuantity, int totalPrice) {
        String query = "SELECT o.CustomerID, c.FirstName, c.LastName, SUM(t.price) as total_price_of_orders FROM CUSTOMER c JOIN PLANT o ON o.CustomerID = c.CustomerID JOIN plant_type t ON t.TypeName = o.PlantType GROUP BY o.CustomerID, c.FirstName, c.LastName HAVING COUNT(*) > ? AND SUM(t.price) > ?";
        Object[] args = { itemQuantity, totalPrice };
        return jdbcTemplate.query(query, new CustomerRowMapper(), args);
    }

    public List<Customer> getTopXCustomers(int limit) {
        String query = "SELECT o.CustomerID, c.FirstName, c.LastName, COUNT(*) AS total_orders FROM CUSTOMER c JOIN PLANT o ON c.CustomerID = o.CustomerID GROUP BY o.CustomerID, c.FirstName, c.LastName FETCH FIRST ? ROWS ONLY";
        Object[] args = { limit };
        return jdbcTemplate.query(query, new CustomerRowMapper(), args);
    }

}
