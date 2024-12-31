package com.pranav.springBootH2.service;

import com.pranav.springBootH2.model.WorkerAddress;
import com.pranav.springBootH2.model.Workers;
import com.pranav.springBootH2.repository.WorkerAddressRepository;
import com.pranav.springBootH2.repository.WorkerRepository;
import com.pranav.springBootH2.repository.WorkersDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerAddressService {
    @Autowired
    private WorkerAddressRepository repository;

    @Autowired
    private WorkerRepository workers;

    public WorkerAddress add(WorkerAddress workerAddress) {
        workers.findById(workerAddress.getWorkers().getId()).orElseThrow(() -> new IllegalArgumentException("NO WORKER FOUND IN THIS ID"));
//        workerAddress.setWorkers(v);
        return repository.save(workerAddress);
    }

    public List<WorkerAddress> list() {
        return repository.findAll();
    }

    public WorkerAddress getById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Details not found"));
    }

    public WorkerAddress update(int id, WorkerAddress address) {
        WorkerAddress address1 = getById(id);
        address1.setStreet(address.getStreet());
        address1.setCity(address.getCity());
        address1.setState(address.getState());
        return repository.save(address1);
    }

    public void delete(int id) {
        getById(id);
        repository.deleteById(id);
    }
}
