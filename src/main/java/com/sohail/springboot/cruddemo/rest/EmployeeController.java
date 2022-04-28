package com.sohail.springboot.cruddemo.rest;
import com.sohail.springboot.cruddemo.dao.EmployeeDAO;
import com.sohail.springboot.cruddemo.entity.Employee;
import com.sohail.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findall(){
        return employeeService.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        if (employeeService.findById(id)==null){
            throw new EmployeetNotFoundException("No employee with id: "+id);
        }
        return employeeService.findById(id);
    }
    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public String update(@RequestBody Employee employee){
        employeeService.save(employee);
        return "Employee: "+employee+"Saved";
    }
    @DeleteMapping("/employees/{id}")
    public String deleteById(@PathVariable int id){
        employeeService.deleteById(id);
        return "deleted id : "+id+"successful";
    }
}
