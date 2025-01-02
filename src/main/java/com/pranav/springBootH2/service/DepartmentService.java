package com.pranav.springBootH2.service;

import com.pranav.springBootH2.model.Department;
import com.pranav.springBootH2.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public Department add(Department department) {
        return repository.save(department);
    }

    public List<Department> list() {
        return repository.findAll();
    }

    public Department getById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("NO DETAILS FOUND"));
    }

    public Department update(int id, Department department) {
        Department department1 = getById(id);
        department1.setId(department.getId());
        department1.setDepartment(department.getDepartment());
        return repository.save(department1);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
