package com.pranav.springBootH2.repository;

import com.pranav.springBootH2.model.WorkerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerAddressRepository extends JpaRepository<WorkerAddress, Integer> {
}
