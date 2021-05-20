package com.pizza.model.dao.impl;

import com.pizza.model.dao.GenericDAO;
import com.pizza.model.entity.OrderStatusEntity;
import com.pizza.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public class OrderStatusDao implements GenericDAO<OrderStatusEntity> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<OrderStatusEntity> findAll() {
        List<OrderStatusEntity> orderStatus = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            orderStatus = session.createQuery("from OrderStatusEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderStatus;
    }

    @Override
    public OrderStatusEntity findOne(Integer id) throws SQLException {
        OrderStatusEntity orderStatus = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            orderStatus = session.get(OrderStatusEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderStatus;
    }

    @Override
    public void create(OrderStatusEntity orderStatus) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(orderStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, OrderStatusEntity orderStatus) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(orderStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            OrderStatusEntity orderStatus = session.get(OrderStatusEntity.class, id);
            if (orderStatus != null) {
                session.delete(orderStatus);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
