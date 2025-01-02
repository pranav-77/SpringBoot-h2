package com.pranav.springBootH2.repository;

import com.pranav.springBootH2.model.WorkersDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersDepartmentRepository extends JpaRepository<WorkersDepartment, Integer> {
}
