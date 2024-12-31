package com.pranav.springBootH2.service;

import com.pranav.springBootH2.model.Workers;
import com.pranav.springBootH2.model.WorkersDepartment;
import com.pranav.springBootH2.repository.WorkerAddressRepository;
import com.pranav.springBootH2.repository.WorkerRepository;
import com.pranav.springBootH2.repository.WorkersDepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkersDepartmentRepository repo;

    public Workers add(Workers workers) {
        log.info("Added Worker");
        repo.findById(workers.getDepartment().getId()).orElseThrow(() -> new RuntimeException("department not present by the id"));
        return workerRepository.save(workers);
    }

    public List<Workers> workersList() {
        log.info("Fetching details");
        return workerRepository.findAll();
    }

    public Workers getById(int id) {
        log.info("Searching by id");
        return workerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No data found"));
    }

    public Workers updateById(int id, Workers workers) {
        Workers workers1 = getById(id);
        workers1.setFirstName(workers.getFirstName());
        workers1.setLastName(workers.getLastName());
        workers1.setEmail(workers.getEmail());
        workers1.setPhoneNo(workers.getPhoneNo());
        workers1.setSalary(workers.getSalary());
        workers1.setGender(workers.getGender());
        workers1.setDepartment(workers.getDepartment());
        log.info("updating data");
        return workerRepository.save(workers1);
    }

    public void deleteById(int id) {
        log.info("Deleting data");
        workerRepository.deleteById(id);
    }

    public List<Workers> getList(int id) {
        WorkersDepartment w= repo.findById(id).get();
        return workerRepository.findByDepartment(w);
    }
}
