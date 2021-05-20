package com.pizza.model.dao.impl;


import com.pizza.model.dao.GenericDAO;

import com.pizza.model.entity.DeliveryAreaEntity;
import com.pizza.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public class DeliveryAreaDao implements GenericDAO<DeliveryAreaEntity> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<DeliveryAreaEntity> findAll() {
        List<DeliveryAreaEntity> deliveryArea = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            deliveryArea = session.createQuery("from DeliveryAreaEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryArea;
    }

    @Override
    public DeliveryAreaEntity findOne(Integer id) throws SQLException {
        DeliveryAreaEntity deliveryArea = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            deliveryArea = session.get(DeliveryAreaEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryArea;
    }

    @Override
    public void create(DeliveryAreaEntity deliveryArea) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(deliveryArea);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, DeliveryAreaEntity deliveryArea) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(deliveryArea);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            DeliveryAreaEntity deliveryArea = session.get(DeliveryAreaEntity.class, id);
            if (deliveryArea != null) {
                session.delete(deliveryArea);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
