package com.pranav.springBootH2.service;

import com.pranav.springBootH2.dto.EmployeeResponseDto;
import com.pranav.springBootH2.model.Address;
import com.pranav.springBootH2.repository.AddressRepository;
import com.pranav.springBootH2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired
    private AddressRepository repository;

    @Autowired
    private EmployeeRepository workers;

    public Address add(Address address) {
        workers.findById(address.getEmployee().getId()).orElseThrow(() -> new IllegalArgumentException("NO WORKER FOUND IN THIS ID"));
        return repository.save(address);
    }

    public List<EmployeeResponseDto> list() {
        return repository.findAll()
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }

    private EmployeeResponseDto convert(Address address) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setId(address.getEmployee().getId());
        dto.setFirstName(address.getEmployee().getFirstName());
        dto.setLastName(address.getEmployee().getLastName());
        dto.setEmail(address.getEmployee().getEmail());
        dto.setDepartment(address.getEmployee().getDepartment().getDepartment());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        return dto;
    }

    public EmployeeResponseDto getById(int id) {
        Address address = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Details not found"));
        return convert(address);
    }

    public Address findById(int id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("No details found"));
    }

    public Address update(int id, Address address) {
        Address address1 = findById(id);
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
