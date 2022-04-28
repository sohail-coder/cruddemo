package com.sohail.springboot.cruddemo.service;

import com.sohail.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
    public void update(Employee employee);

}
