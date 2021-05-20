package com.pizza.lab4.controller.impl;

import com.pizza.lab4.controller.AbstractController;
import com.pizza.lab4.model.dao.impl.OrderStatusDao;
import com.pizza.lab4.model.entity.OrderStatus;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrderStatusController implements AbstractController<OrderStatus> {
    private final OrderStatusDao orderStatusControllerDao = new OrderStatusDao();

    @Override
    public ArrayList<OrderStatus> findAll() throws SQLException {
        return orderStatusControllerDao.findAll();
    }
    @Override
    public OrderStatus findOne(Integer id) throws SQLException {
        return orderStatusControllerDao.findOne(id);
    }

    @Override
    public void create(OrderStatus entity) throws SQLException {
        orderStatusControllerDao.create(entity);
    }

    @Override
    public void update(Integer id, OrderStatus entity) throws SQLException {
        orderStatusControllerDao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        orderStatusControllerDao.delete(id);
    }
}