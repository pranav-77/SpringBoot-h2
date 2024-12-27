package com.pranav.springBootH2.controller;

import com.pranav.springBootH2.model.Student;
import com.pranav.springBootH2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/add")
	public Student add(@RequestBody Student student) {
		System.out.println(student);
		return studentService.addStudent(student);
	}

	@GetMapping("/list")
	public List<Student> studentList() {
		return studentService.getAllStudents();
	}

	@GetMapping("/detail/{id}")
	public Student getById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		studentService.deleteById(id);
	}

	@PutMapping("/update/{id}")
	public Student update(@PathVariable int id, @RequestBody Student student) {
		return studentService.update(id,student);
	}
}
