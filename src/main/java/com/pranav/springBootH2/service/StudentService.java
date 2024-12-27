package com.pranav.springBootH2.service;

import com.pranav.springBootH2.model.Student;
import com.pranav.springBootH2.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No Details Found"));
    }

    public void deleteById(int id) {
        getStudentById(id);
        studentRepository.deleteById(id);
    }

    public Student update(int id, Student student) {
        getStudentById(id);
        student.setId(id);
        return studentRepository.save(student);
    }
}
