package com.pizza.controller.impl;

import com.pizza.controller.GenericController;
import com.pizza.model.dao.impl.CourierStatusDao;
import com.pizza.model.entity.CourierStatusEntity;
import java.sql.SQLException;
import java.util.List;

public class CourierStatusController implements GenericController<CourierStatusEntity> {

    CourierStatusDao dao = new CourierStatusDao();

    @Override
    public List<CourierStatusEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public CourierStatusEntity findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(CourierStatusEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, CourierStatusEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}