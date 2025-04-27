package com.mk.springbootaop.dao;

import com.mk.springbootaop.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getEmployeeById(Integer id);
    List<Employee> getEmployees();

    void addEmployee(Employee employee);
    void addEmployee();
}
