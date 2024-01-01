package com.alvi.RestCrud.service;

import com.alvi.RestCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee save(Employee employee);

    Employee findById(int id);

    void  deleteById(int id);
}
