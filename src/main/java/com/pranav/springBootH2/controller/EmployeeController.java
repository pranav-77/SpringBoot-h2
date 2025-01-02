package com.pranav.springBootH2.controller;

import com.pranav.springBootH2.dto.WorkersDetailsRequestDto;
import com.pranav.springBootH2.dto.WorkersDto;
import com.pranav.springBootH2.model.Workers;
import com.pranav.springBootH2.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @PostMapping("/add")
    public Workers add(@RequestBody Workers workers) {
        return workerService.add(workers);
    }

    @GetMapping("/list")
    public List<WorkersDto> workersList() {
        return workerService.workersList();
    }

    @GetMapping("/search/{id}")
    public WorkersDto getById(@PathVariable int id) {
        return workerService.getById(id);
    }

    @PutMapping("/update/{id}")
    public Workers updateById(@PathVariable int id, @RequestBody Workers workers) {
        return workerService.updateById(id, workers);
    }

    @GetMapping("/getByDeptId/{id}")
    public List<Workers> getList(@PathVariable int id) {
        return workerService.getList(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id) {
        workerService.deleteById(id);
    }
}
