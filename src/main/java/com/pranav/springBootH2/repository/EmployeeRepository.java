package com.pranav.springBootH2.repository;

import com.pranav.springBootH2.model.Employee;
import com.pranav.springBootH2.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment(Department dept);
}
