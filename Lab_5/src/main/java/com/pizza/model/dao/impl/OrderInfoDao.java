package com.pizza.model.dao.impl;

import com.pizza.model.dao.GenericDAO;

import com.pizza.model.entity.OrderInfoEntity;
import com.pizza.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public class OrderInfoDao implements GenericDAO<OrderInfoEntity> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<OrderInfoEntity> findAll() {
        List<OrderInfoEntity> orderInfo = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            orderInfo = session.createQuery("from OrderInfoEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderInfo;
    }

    @Override
    public OrderInfoEntity findOne(Integer id) throws SQLException {
        OrderInfoEntity orderInfo = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            orderInfo = session.get(OrderInfoEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderInfo;
    }

    @Override
    public void create(OrderInfoEntity orderInfo) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(orderInfo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, OrderInfoEntity orderInfo) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(orderInfo);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            OrderInfoEntity orderInfo = session.get(OrderInfoEntity.class, id);
            if (orderInfo != null) {
                session.delete(orderInfo);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
