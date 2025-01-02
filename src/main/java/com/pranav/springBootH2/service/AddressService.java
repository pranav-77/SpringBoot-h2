package com.pranav.springBootH2.service;

import com.pranav.springBootH2.dto.WorkersDetailsResponseDto;
import com.pranav.springBootH2.model.WorkerAddress;
import com.pranav.springBootH2.repository.WorkerAddressRepository;
import com.pranav.springBootH2.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<WorkersDetailsResponseDto> list() {
        return repository.findAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private WorkersDetailsResponseDto convert(WorkerAddress workerAddress) {
        WorkersDetailsResponseDto dto = new WorkersDetailsResponseDto();
        dto.setId(workerAddress.getWorkers().getId());
        dto.setFirstName(workerAddress.getWorkers().getFirstName());
        dto.setLastName(workerAddress.getWorkers().getLastName());
        dto.setEmail(workerAddress.getWorkers().getEmail());
        dto.setDepartment(workerAddress.getWorkers().getDepartment().getDepartment());
        dto.setCity(workerAddress.getCity());
        dto.setState(workerAddress.getState());
        return dto;
    }

    public WorkersDetailsResponseDto getById(int id) {
        WorkerAddress workerAddress = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Details not found"));
        return convert(workerAddress);
    }

    public WorkerAddress findById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No details found"));
    }

    public WorkerAddress update(int id, WorkerAddress address) {
        WorkerAddress address1 = findById(id);
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
