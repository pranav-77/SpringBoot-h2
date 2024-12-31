package com.pranav.springBootH2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkersDepartment {
    @Id
    @GeneratedValue
    private int id;
    private String department;

    @OneToMany(mappedBy = "department")
    private List<Workers> workers;
}
