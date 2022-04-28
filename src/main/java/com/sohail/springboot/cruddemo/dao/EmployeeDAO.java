package com.sohail.springboot.cruddemo.dao;

import com.sohail.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
    public void updateById(Employee employee);
}
