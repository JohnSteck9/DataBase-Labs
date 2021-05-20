package com.pizza.controller.impl;

import com.pizza.controller.GenericController;
import com.pizza.model.dao.impl.OrderStatusDao;
import com.pizza.model.entity.OrderStatusEntity;
import java.sql.SQLException;
import java.util.List;


public class OrderStatusController implements GenericController<OrderStatusEntity> {

    OrderStatusDao dao = new OrderStatusDao();

    @Override
    public List<OrderStatusEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public OrderStatusEntity findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(OrderStatusEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, OrderStatusEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}
