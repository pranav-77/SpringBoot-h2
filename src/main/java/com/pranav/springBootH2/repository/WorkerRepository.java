package com.pranav.springBootH2.repository;

import com.pranav.springBootH2.model.Workers;
import com.pranav.springBootH2.model.WorkersDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Workers, Integer> {
    List<Workers> findByDepartment(WorkersDepartment dept);
}
