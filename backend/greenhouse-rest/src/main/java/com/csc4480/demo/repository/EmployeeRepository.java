package com.csc4480.demo.repository;

import com.csc4480.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> findAll() {
        String sql = "SELECT * FROM EMPLOYEE";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public Employee findById(int id) {
        String sql = "SELECT * FROM EMPLOYEE WHERE EmployeeID = ?";
        Object[] args = { id };
        return jdbcTemplate.queryForObject(sql, new EmployeeRepository.EmployeeRowMapper(), args);
    }

    public List<Employee> findByLocation(int locationId) {
        String sql = "SELECT * FROM EMPLOYEE WHERE LocationID = ?";
        Object[] args = { locationId };
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), args);
    }

    public Employee save(Employee employee) {
        String sql = "INSERT INTO EMPLOYEE(FirstName, MInit, LastName, EmployeeID, LocationID) " +
                "VALUES (?, ?, ?, ?, ?)";
        Object[] args = { employee.getFirstName(), employee.getmInit(), employee.getLastName(),
                employee.getEmployeeID(), employee.getLocationID() };
        jdbcTemplate.update(sql, args);
        return employee;
    }

    public void update(Employee employee) {
        String sql = "UPDATE EMPLOYEE SET FirstName = ?, MInit = ?, LastName = ?, LocationID = ? " +
                "WHERE EmployeeID = ?";
        Object[] args = { employee.getFirstName(), employee.getmInit(), employee.getLastName(),
                employee.getLocationID(), employee.getEmployeeID() };
        jdbcTemplate.update(sql, args);
    }

    public void deleteById(int employeeId) {
        String sql = "DELETE FROM EMPLOYEE WHERE EmployeeID = ?";
        Object[] args = { employeeId };
        jdbcTemplate.update(sql, args);
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setFirstName(rs.getString("FirstName"));
            employee.setmInit(rs.getString("MInit"));
            employee.setLastName(rs.getString("LastName"));
            employee.setEmployeeID(rs.getInt("EmployeeID"));
            employee.setLocationID(rs.getInt("LocationID"));
            return employee;
        }
    }
}
