package com.pizza.lab4.model.dao.impl;

import static com.pizza.lab4.util.DatabaseConnector.getConnection;
import com.pizza.lab4.model.dao.AbstractDao;
import com.pizza.lab4.model.entity.CourierStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class CourierStatusDao implements AbstractDao<CourierStatus> {
    private static final String GET_ALL_QUERY = "SELECT * FROM pizza_project.courier_status;";
    private static final String GET_ONE_QUERY = "SELECT * FROM pizza_project.courier_status WHERE "
            + "id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO pizza_project.courier_status "
            + "(status) VALUES (?);";
    private static final String UPDATE_QUERY = "UPDATE pizza_project.courier_status SET "
            + "status = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM pizza_project.courier_status WHERE "
            + "id = ?;";

    @Override
    public ArrayList<CourierStatus> findAll() {
        ArrayList<CourierStatus> courierStatuses = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY)) {
            while (resultSet.next()) {
                CourierStatus courierStatus = new CourierStatus(
                        resultSet.getInt("id"),
                        resultSet.getString("status")
                );
                courierStatuses.add(courierStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courierStatuses;
    }

    @Override
    public CourierStatus findOne(Integer id) {
        CourierStatus courierStatus = null;
        ResultSet resultSet;
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                courierStatus = new CourierStatus(
                        resultSet.getInt("id"),
                        resultSet.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courierStatus;
    }

    @Override
    public void create(CourierStatus entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
//            statement.setInt(1, entity.getId());
            statement.setString(1, entity.getStatus());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, CourierStatus entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, entity.getStatus());
            statement.setInt(2, id);
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
