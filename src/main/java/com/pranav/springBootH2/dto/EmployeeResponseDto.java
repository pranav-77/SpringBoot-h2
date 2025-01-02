package com.pranav.springBootH2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
    private String city;
    private String state;
}
