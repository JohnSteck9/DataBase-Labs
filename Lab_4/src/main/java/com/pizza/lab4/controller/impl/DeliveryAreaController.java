package com.pizza.lab4.controller.impl;

import com.pizza.lab4.controller.AbstractController;
import com.pizza.lab4.model.dao.impl.DeliveryAreaDao;
import com.pizza.lab4.model.entity.DeliveryArea;
import java.sql.SQLException;
import java.util.ArrayList;


public class DeliveryAreaController implements AbstractController<DeliveryArea> {
    private final DeliveryAreaDao deliveryAreaDao = new DeliveryAreaDao();

    @Override
    public ArrayList<DeliveryArea> findAll() throws SQLException {
        return deliveryAreaDao.findAll();
    }
    @Override
    public DeliveryArea findOne(Integer id) throws SQLException {
        return deliveryAreaDao.findOne(id);
    }

    @Override
    public void create(DeliveryArea entity) throws SQLException {
        deliveryAreaDao.create(entity);
    }

    @Override
    public void update(Integer id, DeliveryArea entity) throws SQLException {
        deliveryAreaDao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        deliveryAreaDao.delete(id);
    }
}