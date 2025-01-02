package com.pranav.springBootH2.service;

import com.pranav.springBootH2.dto.WorkersDetailsRequestDto;
import com.pranav.springBootH2.dto.WorkersDto;
import com.pranav.springBootH2.model.WorkerAddress;
import com.pranav.springBootH2.model.Workers;
import com.pranav.springBootH2.model.WorkersDepartment;
import com.pranav.springBootH2.repository.WorkerAddressRepository;
import com.pranav.springBootH2.repository.WorkerRepository;
import com.pranav.springBootH2.repository.WorkersDepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkersDepartmentRepository repo;

    @Autowired
    private WorkerAddressRepository addressRepository;

    public Workers add(Workers workers) {
        log.info("Added Worker");
        repo.findById(workers.getDepartment().getId()).orElseThrow(() -> new RuntimeException("department not present by the id"));
//        Workers workers1 = new Workers();
//        workers1.setFirstName(workers.getFirstName());
//        workers1.setLastName(workers.getLastName());
//        workers1.setEmail(workers.getEmail());
//        workers1.setPhoneNo(workers.getPhoneNo());
//        workers1.setSalary(workers.getSalary());
//        workers1.setGender(workers.getGender());
//
//        List<WorkerAddress> addresses = new ArrayList<>();
//        if (workers.getAddress() != null) {
//            workers.getAddress().forEach(workerAddress -> {
//                WorkerAddress address = new WorkerAddress();
//                address.setStreet(workerAddress.getStreet());
//                address.setCity(workerAddress.getCity());
//                address.setState(workerAddress.getState());
//                address.setWorkers(workers1);
//                addresses.add(address);
//            });
//        }
////        repo.findById(workers1.getDepartment().getId()).orElseThrow(() -> new IllegalArgumentException("not found"));
//        workers1.setAddress(addresses);
//        addressRepository.saveAll(addresses);
//        return workerRepository.save(workers1);
        List<WorkerAddress> addresses = workers.getAddress();
        Workers workers1= workerRepository.save(workers);
        for (int i=0 ; i<addresses.size() ; i++)
        {
            addresses.get(i).setWorkers(workers1);
        }
        addressRepository.saveAll(addresses);
        return workers1;
    }

    public List<WorkersDto> workersList() {
        log.info("Fetching details");
        return workerRepository.findAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private WorkersDto convert(Workers workers) {
        WorkersDto workersDto = new WorkersDto();
        workersDto.setId(workers.getId());
        workersDto.setFirstName(workers.getFirstName());
        workersDto.setLastName(workers.getLastName());
        workersDto.setEmail(workers.getEmail());
        workersDto.setDepartment(workers.getDepartment().getDepartment());
        return workersDto;
    }

    public WorkersDto getById(int id) {
        log.info("Searching by id");
        Workers workers = workerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No data found"));
        return convert(workers);
    }

    public Workers findById(int id) {
        return workerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Details Found"));
    }

    public Workers updateById(int id, Workers workers) {
        Workers workers1 = findById(id);
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
        WorkersDepartment w = repo.findById(id).get();
        return workerRepository.findByDepartment(w);
    }
}
