package com.mk.springbootaop.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Employee {
    private int id;
    private String name;
    private String employeeId;
    private String department;
}
