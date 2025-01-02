package com.pranav.springBootH2.service;

import com.pranav.springBootH2.model.Address;
import com.pranav.springBootH2.model.Employee;
import com.pranav.springBootH2.model.Department;
import com.pranav.springBootH2.repository.AddressRepository;
import com.pranav.springBootH2.repository.EmployeeRepository;
import com.pranav.springBootH2.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository repo;

    @Autowired
    private AddressRepository addressRepository;

    public Employee add(Employee employee) {
        log.info("Added Worker");
        repo.findById(employee.getDepartment().getId()).orElseThrow(() -> new RuntimeException("department not present by the id"));
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
        List<Address> addresses = employee.getAddress();
        Employee employee1 = employeeRepository.save(employee);
        for (int i=0 ; i<addresses.size() ; i++)
        {
            addresses.get(i).setEmployee(employee1);
        }
        addressRepository.saveAll(addresses);
        return employee1;
    }

    public List<Employee> workersList() {
        log.info("Fetching details");
        return employeeRepository.findAll();
    }

    public Employee getById(int id) {
        log.info("Searching by id");
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No data found"));
    }

    public Employee updateById(int id, Employee employee) {
        Employee employee1 = getById(id);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employee1.setPhoneNo(employee.getPhoneNo());
        employee1.setSalary(employee.getSalary());
        employee1.setGender(employee.getGender());
        employee1.setDepartment(employee.getDepartment());
        log.info("updating data");
        return employeeRepository.save(employee1);
    }

    public void deleteById(int id) {
        log.info("Deleting data");
        employeeRepository.deleteById(id);
    }

    public List<Employee> getList(int id) {
        Department w = repo.findById(id).get();
        return employeeRepository.findByDepartment(w);
    }
}
