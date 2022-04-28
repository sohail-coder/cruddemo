package com.sohail.springboot.cruddemo.dao;

import com.sohail.springboot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        Session session=entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee",Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Session session=entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class,id);
        return employee;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        employee.setId(0);
        session.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session session=entityManager.unwrap(Session.class);
        String qryString3 = "delete from Employee e where e.id=:eId";
        Query query3 = session.createQuery(qryString3);
        query3.setParameter("eId", id);
        query3.executeUpdate();
        System.out.println("deleted done 100%");
    }

    @Override
    @Transactional
    public void updateById(Employee employee) {
        Session session=entityManager.unwrap(Session.class);
        session.update(employee);
        System.out.println("updated");
    }
}
