package com.pranav.springBootH2.dto;

import com.pranav.springBootH2.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNo;
    private double salary;
    private String gender;
    private List<Address> address;
}
