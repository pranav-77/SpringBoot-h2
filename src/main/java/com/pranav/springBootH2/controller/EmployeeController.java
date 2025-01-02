package com.pranav.springBootH2.controller;

import com.pranav.springBootH2.model.Employee;
import com.pranav.springBootH2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee add(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @GetMapping("/list")
    public List<Employee> workersList() {
        return employeeService.workersList();
    }

    @GetMapping("/search/{id}")
    public Employee getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateById(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateById(id, employee);
    }

    @GetMapping("/getByDeptId/{id}")
    public List<Employee> getList(@PathVariable int id) {
        return employeeService.getList(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        employeeService.deleteById(id);
    }
}
