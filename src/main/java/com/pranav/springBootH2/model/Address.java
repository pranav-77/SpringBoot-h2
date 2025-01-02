package com.pranav.springBootH2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private int addressId;
    private String street;
    private String city;
    private String state;

    @ManyToOne
    private Employee employee;
}
