package com.pranav.springBootH2.controller;

import com.pranav.springBootH2.model.WorkerAddress;
import com.pranav.springBootH2.service.WorkerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class WorkerAddressController {
    @Autowired
    private WorkerAddressService addressService;

    @PostMapping("/add")
    public WorkerAddress add(@RequestBody WorkerAddress workerAddress) {
        return addressService.add(workerAddress);
    }

    @GetMapping("/list")
    public List<WorkerAddress> list() {
        return addressService.list();
    }

    @GetMapping("/search/{id}")
    public WorkerAddress getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PutMapping("/update/{id}")
    public WorkerAddress update(@PathVariable int id, @RequestBody WorkerAddress address) {
        return addressService.update(id, address);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        addressService.delete(id);
    }
}
