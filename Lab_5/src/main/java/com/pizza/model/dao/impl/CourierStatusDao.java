package com.pizza.model.dao.impl;


import com.pizza.model.dao.GenericDAO;
import com.pizza.model.entity.CourierStatusEntity;
import com.pizza.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public class CourierStatusDao implements GenericDAO<CourierStatusEntity> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<CourierStatusEntity> findAll() {
        List<CourierStatusEntity> courierStatus = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            courierStatus = session.createQuery("from CourierStatusEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courierStatus;
    }

    @Override
    public CourierStatusEntity findOne(Integer id) throws SQLException {
        CourierStatusEntity courierStatus = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            courierStatus = session.get(CourierStatusEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courierStatus;
    }

    @Override
    public void create(CourierStatusEntity courierStatus) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(courierStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, CourierStatusEntity courierStatus) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(courierStatus);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            CourierStatusEntity courierStatus = session.get(CourierStatusEntity.class, id);
            if (courierStatus != null) {
                session.delete(courierStatus);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
