package com.pranav.springBootH2.controller;

import com.pranav.springBootH2.dto.EmployeeResponseDto;
import com.pranav.springBootH2.model.Address;
import com.pranav.springBootH2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public Address add(@RequestBody Address address) {
        return addressService.add(address);
    }

    @GetMapping("/list")
    public List<EmployeeResponseDto> list() {
        return addressService.list();
    }

    @GetMapping("/search/{id}")
    public EmployeeResponseDto getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Address update(@PathVariable int id, @RequestBody Address address) {
        return addressService.update(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }
}
