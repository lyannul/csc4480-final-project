package com.csc4480.demo.service;

import com.csc4480.demo.model.Employee;
import com.csc4480.demo.repository.EmployeeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int employeeId) {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findById(employeeId));
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new EntityNotFoundException("Employee not found with id " + employeeId);
    }

    public Employee createEmployee(Employee employee) {
        System.out.println("HERE");
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int employeeId, Employee employee) {
        Optional<Employee> existingEmployee = Optional.ofNullable(employeeRepository.findById(employeeId));
        if (existingEmployee.isPresent()) {
            employee.setEmployeeID(employeeId);
            return employeeRepository.save(employee);
        }
        throw new EntityNotFoundException("Employee not found with id " + employeeId);
    }

    public void deleteEmployee(int employeeId) {
        Optional<Employee> employee = Optional.ofNullable(employeeRepository.findById(employeeId));
        if (employee.isPresent()) {
            employeeRepository.deleteById(employeeId);
        } else {
            throw new EntityNotFoundException("Employee not found with id " + employeeId);
        }
    }
}

