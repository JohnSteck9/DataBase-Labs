package com.pizza.model.dao.impl;


import com.pizza.model.dao.GenericDAO;
import com.pizza.model.entity.CustomerEntity;
import com.pizza.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({"unchecked", "deprecation", "rawtypes"})
public class CustomerDao implements GenericDAO<CustomerEntity> {

    protected final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerEntity> customer = new ArrayList<>();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            customer = session.createQuery("from CustomerEntity").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public CustomerEntity findOne(Integer id) throws SQLException {
        CustomerEntity customer = null;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            customer = session.get(CustomerEntity.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void create(CustomerEntity customer) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, CustomerEntity customer) throws SQLException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            CustomerEntity customer = session.get(CustomerEntity.class, id);
            if (customer != null) {
                session.delete(customer);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}