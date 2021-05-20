package com.pizza.controller.impl;

import java.sql.SQLException;
import java.util.List;
import com.pizza.controller.GenericController;
import com.pizza.model.dao.impl.CourierDao;
import com.pizza.model.entity.CourierEntity;


public class CourierController implements GenericController<CourierEntity> {

    CourierDao dao = new CourierDao();

    @Override
    public List<CourierEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CourierEntity findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(CourierEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CourierEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}
