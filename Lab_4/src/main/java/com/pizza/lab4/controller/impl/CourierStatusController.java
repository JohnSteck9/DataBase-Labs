package com.pizza.lab4.controller.impl;

import com.pizza.lab4.controller.AbstractController;
import com.pizza.lab4.model.entity.CourierStatus;
import com.pizza.lab4.model.dao.impl.CourierStatusDao;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourierStatusController implements AbstractController<CourierStatus>{
    private final CourierStatusDao courierStatusDao = new CourierStatusDao();

    @Override
    public ArrayList<CourierStatus> findAll() throws SQLException {
        return courierStatusDao.findAll();
    }
    @Override
    public CourierStatus findOne(Integer id) throws SQLException {
        return courierStatusDao.findOne(id);
    }

    @Override
    public void create(CourierStatus entity) throws SQLException {
        courierStatusDao.create(entity);
    }

    @Override
    public void update(Integer id, CourierStatus entity) throws SQLException {
        courierStatusDao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        courierStatusDao.delete(id);
    }
}