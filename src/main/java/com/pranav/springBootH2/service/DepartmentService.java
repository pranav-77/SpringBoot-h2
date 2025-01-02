package com.pranav.springBootH2.service;

import com.pranav.springBootH2.model.WorkersDepartment;
import com.pranav.springBootH2.repository.WorkersDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerDepartmentService {
    @Autowired
    private WorkersDepartmentRepository repository;

    public WorkersDepartment add(WorkersDepartment department) {
        return repository.save(department);
    }

    public List<WorkersDepartment> list() {
        return repository.findAll();
    }

    public WorkersDepartment getById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("NO DETAILS FOUND"));
    }

    public WorkersDepartment update(int id, WorkersDepartment department) {
        WorkersDepartment department1 = getById(id);
        department1.setId(department.getId());
        department1.setDepartment(department.getDepartment());
        return repository.save(department1);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
