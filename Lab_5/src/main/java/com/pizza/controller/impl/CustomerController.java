package com.pizza.controller.impl;

import com.pizza.controller.GenericController;
import com.pizza.model.dao.impl.CustomerDao;
import com.pizza.model.entity.CustomerEntity;
import java.sql.SQLException;
import java.util.List;

public class CustomerController implements GenericController<CustomerEntity> {

    CustomerDao dao = new CustomerDao();

    @Override
    public List<CustomerEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CustomerEntity findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(CustomerEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CustomerEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}
