package com.mk.springbootaop.dao.impl;

import com.mk.springbootaop.dao.EmployeeDAO;
import com.mk.springbootaop.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee getEmployeeById(Integer id) {
        if (id == null) {
            throw new RuntimeException("Wrong ID");
        }

        System.out.println(getClass() + ": getEmployeeById with id: " + id);
        return Employee.builder()
                .id(id)
                .name("John Doe")
                .employeeId("Emp_1")
                .department("IT")
                .build();
    }

    @Override
    public List<Employee> getEmployees() {
        System.out.println(getClass() + ": getEmployees");
        return List.of(
                Employee.builder()
                        .id(1)
                        .name("John Doe")
                        .employeeId("Emp_1")
                        .department("IT")
                        .build(),
                Employee.builder()
                        .id(2)
                        .name("Jane Doe")
                        .employeeId("Emp_2")
                        .department("Marketing")
                        .build()
        );
    }

    @Override
    public void addEmployee(Employee employee) {
        System.out.println(getClass() + ": addEmployee with Employee: ");
    }

    @Override
    public void addEmployee() {
        System.out.println(getClass() + ": addEmployee: ");
    }
}
