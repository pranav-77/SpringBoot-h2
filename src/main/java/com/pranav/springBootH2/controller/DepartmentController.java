package com.pranav.springBootH2.controller;

import com.pranav.springBootH2.model.WorkersDepartment;
import com.pranav.springBootH2.service.WorkerDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class WorkerDepartmentController {
    @Autowired
    private WorkerDepartmentService service;

    @PostMapping("/add")
    public WorkersDepartment add(@RequestBody WorkersDepartment department) {
        return service.add(department);
    }

    @GetMapping("/list")
    public List<WorkersDepartment> list() {
        return service.list();
    }

    @GetMapping("/search/{id}")
    public WorkersDepartment getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/update/{id}")
    public WorkersDepartment update(@PathVariable int id, @RequestBody WorkersDepartment department) {
        return service.update(id, department);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
