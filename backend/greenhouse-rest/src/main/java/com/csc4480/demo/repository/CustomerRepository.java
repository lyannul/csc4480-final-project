package com.csc4480.demo.repository;

import com.csc4480.demo.model.Customer;
import com.csc4480.demo.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer getById(int id) {
        String sql = "SELECT * FROM CUSTOMER WHERE CustomerID = ?";
        Object[] args = new Object[] { id };
        return jdbcTemplate.queryForObject(sql, new CustomerRepository.CustomerRowMapper(), args);
    }

    public List<Customer> getAll() {
        String query = "SELECT * FROM CUSTOMER";
        return jdbcTemplate.query(query, new CustomerRowMapper());
    }

    public void create(Customer customer) {
        String query = "INSERT INTO CUSTOMER (FirstName, MInit, LastName, CustomerID, UserName, WebPassword) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, customer.getFirstName(), customer.getmInit(), customer.getLastName(), customer.getCustomerID(), customer.getUserName(), customer.getWebPassword());
    }

    public void update(Customer customer) {
        String query = "UPDATE CUSTOMER SET FirstName = ?, MInit = ?, LastName = ?, UserName = ?, WebPassword = ? WHERE CustomerID = ?";
        jdbcTemplate.update(query, customer.getFirstName(), customer.getmInit(), customer.getLastName(), customer.getUserName(), customer.getWebPassword(), customer.getCustomerID());
    }

    public void delete(int id) {
        String query = "DELETE FROM CUSTOMER WHERE CustomerID = ?";
        jdbcTemplate.update(query, id);
    }

    public static class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setFirstName(rs.getString("FirstName"));
            customer.setmInit(rs.getString("MInit"));
            customer.setLastName(rs.getString("LastName"));
            customer.setCustomerID(rs.getInt("CustomerID"));
            customer.setUserName(rs.getString("UserName"));
            customer.setWebPassword(rs.getString("WebPassword"));
            return customer;
        }
    }
}
