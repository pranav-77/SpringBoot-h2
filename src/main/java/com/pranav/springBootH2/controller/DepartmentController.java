package com.pranav.springBootH2.controller;

import com.pranav.springBootH2.model.Department;
import com.pranav.springBootH2.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping("/add")
    public Department add(@RequestBody Department department) {
        return service.add(department);
    }

    @GetMapping("/list")
    public List<Department> list() {
        return service.list();
    }

    @GetMapping("/search/{id}")
    public Department getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public Department update(@PathVariable int id, @RequestBody Department department) {
        return service.update(id, department);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
