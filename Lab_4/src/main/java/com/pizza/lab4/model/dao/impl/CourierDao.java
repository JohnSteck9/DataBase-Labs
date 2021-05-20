package com.pizza.lab4.model.dao.impl;

import static com.pizza.lab4.util.DatabaseConnector.getConnection;

import com.pizza.lab4.model.dao.AbstractDao;
import com.pizza.lab4.model.entity.Courier;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CourierDao implements AbstractDao<Courier> {

    private static final String GET_ALL_QUERY = "SELECT * FROM pizza_project.courier;";
    private static final String GET_ONE_QUERY = "SELECT * FROM pizza_project.courier WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO pizza_project.courier (first_name, last_name, "
            + "phone, email) VALUES (?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE pizza_project.courier SET first_name = ?, last_name = ?, "
            + "phone = ?, email = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM pizza_project.courier WHERE id = ?;";


    @Override
    public ArrayList<Courier> findAll() {
        ArrayList<Courier> couriers = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY)) {
            while (resultSet.next()) {
                Courier courier = new Courier(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getInt("courier_status_id")
                );
                couriers.add(courier);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return couriers;
    }

    @Override
    public Courier findOne(Integer id) throws SQLException {
        Courier courier = null;
        ResultSet resultSet = null;
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                courier = new Courier(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("phone"),
                        resultSet.getString("email"),
                        resultSet.getInt("courier_status_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (resultSet != null) {
            resultSet.close();
        }
        return courier;
    }

    @Override
    public void create(Courier entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, entity.getFirstname());
            statement.setString(2, entity.getLastname());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getEmail());
//            statement.setInt(5, entity.getCourierStatusId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Courier entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, entity.getFirstname());
            statement.setString(2, entity.getLastname());
            statement.setString(3, entity.getPhone());
            statement.setString(4, entity.getEmail());
//            statement.setInt(5, entity.getCourierStatusId());
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