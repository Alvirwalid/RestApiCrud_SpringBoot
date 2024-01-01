package com.alvi.RestCrud.res;

import com.alvi.RestCrud.entity.Employee;
import com.alvi.RestCrud.exception.EmployeeNotFoundException;
import com.alvi.RestCrud.service.EmployeeServiceImp;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    List<Employee>employeeList;




    private EmployeeServiceImp employeeServiceImp;


    @PostConstruct
    public  void  inIt(){

        employeeList=new ArrayList<>();
        employeeList = employeeServiceImp.findAll();
    }

    public EmployeeRestController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }


    @GetMapping("/employees")
    List<Employee> findAll(){
        return  employeeServiceImp.findAll();
    }

    @GetMapping("/employees/{employeeid}")
    Employee getEmployee(@PathVariable int employeeid){

        Employee employee = employeeServiceImp.findById(employeeid);

        if(employee ==null){
            throw  new EmployeeNotFoundException("Employee not found - "+employeeid);
        }

        return  employee;
    }
}
