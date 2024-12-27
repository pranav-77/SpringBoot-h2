package com.pranav.springBootH2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.springBootH2.model.Employee;
import com.pranav.springBootH2.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Details not found"));
    }

    public Employee update(int id, Employee employee) {
        Employee employee1 = getById(id);
        employee1.setName(employee.getName());
        employee1.setSalary(employee.getSalary());
        return employeeRepository.save(employee1);
    }

    public void delete(int id) {
        getById(id);
        employeeRepository.deleteById(id);
    }

}
