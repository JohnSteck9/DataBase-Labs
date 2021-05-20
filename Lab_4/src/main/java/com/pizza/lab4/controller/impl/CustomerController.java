package com.pizza.lab4.controller.impl;

import com.pizza.lab4.controller.AbstractController;
import com.pizza.lab4.model.dao.impl.CustomerDao;
import com.pizza.lab4.model.entity.Customer;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerController implements AbstractController<Customer> {
    private final CustomerDao customerDao = new CustomerDao();

    @Override
    public ArrayList<Customer> findAll() throws SQLException {
        return customerDao.findAll();
    }
    @Override
    public Customer findOne(Integer id) throws SQLException {
        return customerDao.findOne(id);
    }

    @Override
    public void create(Customer entity) throws SQLException {
        customerDao.create(entity);
    }

    @Override
    public void update(Integer id, Customer entity) throws SQLException {
        customerDao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        customerDao.delete(id);
    }
}