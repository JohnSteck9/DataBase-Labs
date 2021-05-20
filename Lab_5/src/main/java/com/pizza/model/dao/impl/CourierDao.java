package com.pizza.model.dao.impl;

import com.pizza.model.dao.GenericDAO;
import com.pizza.model.entity.CourierEntity;
import com.pizza.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public class CourierDao implements GenericDAO<CourierEntity> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<CourierEntity> findAll() {
        List<CourierEntity> courier = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            courier = session.createQuery("from CourierEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courier;
    }

    @Override
    public CourierEntity findOne(Integer id) throws SQLException {
        CourierEntity courier = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            courier = session.get(CourierEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courier;
    }

    @Override
    public void create(CourierEntity courier) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(courier);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, CourierEntity courier) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(courier);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            CourierEntity courier = session.get(CourierEntity.class, id);
            if (courier != null) {
                session.delete(courier);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}