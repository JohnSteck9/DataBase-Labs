package com.pizza.controller.impl;

import com.pizza.controller.GenericController;
import com.pizza.model.dao.impl.DeliveryAreaDao;
import com.pizza.model.entity.DeliveryAreaEntity;
import java.sql.SQLException;
import java.util.List;


public class DeliveryAreaController implements GenericController<DeliveryAreaEntity> {

    DeliveryAreaDao dao = new DeliveryAreaDao();

    @Override
    public List<DeliveryAreaEntity> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public DeliveryAreaEntity findOne(Integer id) throws SQLException {
        return dao.findOne(id);
    }

    @Override
    public void create(DeliveryAreaEntity entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, DeliveryAreaEntity entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);

    }

}