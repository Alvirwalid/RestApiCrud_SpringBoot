package com.alvi.RestCrud.res;

import com.alvi.RestCrud.entity.Employee;
import com.alvi.RestCrud.exception.EmployeeNotFoundException;
import com.alvi.RestCrud.service.EmployeeServiceImp;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
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

        List<Employee>employeeList1=employeeServiceImp.findAll();

        Comparator<Employee> sort=Comparator.comparing(Employee::getId);

        List<Employee>sortedList= employeeList1.stream().sorted(sort.reversed()).toList();

        return  sortedList;
    }

    @GetMapping("/employees/{employeeid}")
    Employee getEmployee(@PathVariable int employeeid){
        Employee employee = employeeServiceImp.findById(employeeid);
        if(employee ==null){
            throw  new EmployeeNotFoundException("Employee not found - "+employeeid);
        }
        return  employee;
    }

    @PostMapping("/employees")
    public  Employee addEmployee(@RequestBody Employee employee){

//        employee.setId(0);
     Employee employee1 =   employeeServiceImp.save(employee);

        return  employee1;
    }

    @PutMapping("/employees")
    public  Employee updateEmployee(@RequestBody Employee employee){
       Employee emp= employeeServiceImp.findById(employee.getId());

        if (employee.getFirstName().isEmpty()) {
            employee.setFirstName(emp.getFirstName());
        } else {
            employee.setFirstName(employee.getFirstName());
        }

        if (employee.getLastName().isEmpty()) {
            employee.setLastName(emp.getLastName());
        } else {
            employee.setLastName(employee.getLastName());
        }

        if (employee.getEmail().isEmpty() || employee.getEmail()==null) {
            employee.setEmail(emp.getEmail());
        } else {
            employee.setEmail(employee.getEmail());
        }

        Employee employee1=employeeServiceImp.save(employee);

        return  employee1;

    }

    @DeleteMapping("/employees/{employeeid}")
    public  String  deleteEmployee(@PathVariable int employeeid){

        Employee employee =employeeServiceImp.findById(employeeid);

        if(employee ==null){

            throw  new EmployeeNotFoundException("Employee id not fount - "+employeeid);

        }

        employeeServiceImp.deleteById(employeeid);

        return  "Deleted id - " +employeeid;

    }
}
