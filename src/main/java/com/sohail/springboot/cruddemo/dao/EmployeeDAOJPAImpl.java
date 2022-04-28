package com.sohail.springboot.cruddemo.dao;

import com.sohail.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

@Service
public class EmployeeDAOJPAImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Query query =  entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;

    }

    @Override
    @Transactional
    public Employee findById(int id) {
       Employee employee = entityManager.find(Employee.class,id);
       return employee;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Employee employee1 = entityManager.merge(employee);
        employee.setId(employee1.getId());
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:eid");
        query.setParameter("eid",id);
        query.executeUpdate();

    }

    @Override
    public void updateById(Employee employee) {

    }
}
