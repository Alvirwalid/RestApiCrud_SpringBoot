package com.alvi.RestCrud.dao;

import com.alvi.RestCrud.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements  EmployeeDAO{


   private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public Employee save(Employee employee) {

        Employee employee1 = entityManager.merge(employee);
        return employee1;
    }
    @Override
    public Employee findById(int id) {

        Employee employee =entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public void deleteById(int id) {
         Employee employee = entityManager.find(Employee.class,id);


         entityManager.remove(employee);

    }

    @Override
    public List<Employee> findAll() {
        //create query to get list

        TypedQuery<Employee>query= entityManager.createQuery("FROM Employee",Employee.class);

        //return result


        return query.getResultList();
    }


}
