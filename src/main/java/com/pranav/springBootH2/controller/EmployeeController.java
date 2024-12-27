package com.pranav.springBootH2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pranav.springBootH2.model.Employee;
import com.pranav.springBootH2.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/list")
    public List<Employee> list() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Employee update(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        employeeService.delete(id);
    }
}
