package com.pranav.springBootH2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Workers {
    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private String email;

    @Column(unique = true)
    private Long phoneNo;

    private double salary;
    private String gender;

    @ManyToOne
    private WorkersDepartment department;

    @OneToMany(mappedBy = "workers")
    private List<WorkerAddress> address;
}
