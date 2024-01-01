package com.alvi.RestCrud.dao;

import com.alvi.RestCrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee save(Employee employee);

   Employee findById(int id);

   void  deleteById(int id);


}
