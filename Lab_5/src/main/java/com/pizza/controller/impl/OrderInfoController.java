package com.pizza.controller.impl;

import com.pizza.controller.GenericController;
import com.pizza.model.dao.impl.OrderInfoDao;
import com.pizza.model.entity.OrderInfoEntity;
import java.sql.SQLException;
import java.util.List;


public class OrderInfoController implements GenericController<OrderInfoEntity> {

    OrderInfoDao dao = new OrderInfoDao();

    @Override
    public List<OrderInfoEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public OrderInfoEntity findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(OrderInfoEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, OrderInfoEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}