package com.pizza.lab4.controller.impl;

import com.pizza.lab4.controller.AbstractController;
import com.pizza.lab4.model.dao.impl.OrderInfoDao;
import com.pizza.lab4.model.entity.OrderInfo;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrderInfoController implements AbstractController<OrderInfo> {
    private final OrderInfoDao orderInfoDao = new OrderInfoDao();

    @Override
    public ArrayList<OrderInfo> findAll() throws SQLException {
        return orderInfoDao.findAll();
    }
    @Override
    public OrderInfo findOne(Integer id) throws SQLException {
        return orderInfoDao.findOne(id);
    }

    @Override
    public void create(OrderInfo entity) throws SQLException {
        orderInfoDao.create(entity);
    }

    @Override
    public void update(Integer id, OrderInfo entity) throws SQLException {
        orderInfoDao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        orderInfoDao.delete(id);
    }
}