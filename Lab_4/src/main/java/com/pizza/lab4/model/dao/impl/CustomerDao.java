package com.pizza.lab4.model.dao.impl;

import static com.pizza.lab4.util.DatabaseConnector.getConnection;
import com.pizza.lab4.model.dao.AbstractDao;
import com.pizza.lab4.model.entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDao implements AbstractDao<Customer> {
    private static final String GET_ALL_QUERY = "SELECT * FROM pizza_project.customer;";
    private static final String GET_ONE_QUERY = "SELECT * FROM pizza_project.customer "
            + "WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO pizza_project.customer "
            + "(first_name, last_name, phone, email) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE pizza_project.customer "
            + "SET first_name = ?, last_name = ?, phone = ?, email = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM pizza_project.customer "
            + "WHERE id = ?;";

    @Override
    public ArrayList<Customer> findAll() {
        ArrayList<Customer> customers = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY)) {
            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                );
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findOne(Integer id) throws SQLException {
        Customer customer = null;
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null) {
            resultSet.close();
        }
        return customer;
    }

    @Override
    public void create(Customer entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
//            statement.setInt(1, entity.getId());
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getEmail());
            statement.setString(4, entity.getPhone());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Customer entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, entity.getFirstName());
            statement.setString(2, entity.getLastName());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getEmail());
            statement.setInt(5, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = getConnection().prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
