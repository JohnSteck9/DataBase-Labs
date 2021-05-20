package com.pizza.lab4.model.dao.impl;

import static com.pizza.lab4.util.DatabaseConnector.getConnection;
import com.pizza.lab4.model.dao.AbstractDao;
import com.pizza.lab4.model.entity.OrderStatus;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class OrderStatusDao implements AbstractDao<OrderStatus> {

    private static final String GET_ALL_QUERY = "SELECT * FROM pizza_project.order_status;";
    private static final String GET_ONE_QUERY = "SELECT * FROM pizza_project.order_status WHERE "
            + "id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO pizza_project.order_status "
            + "(status) VALUES (?);";
    private static final String UPDATE_QUERY = "UPDATE pizza_project.order_status SET "
            + "status = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM pizza_project.order_status WHERE "
            + "id = ?;";

    @Override
    public ArrayList<OrderStatus> findAll() {
        ArrayList<OrderStatus> orderStatuses = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY)) {
            while (resultSet.next()) {
                OrderStatus orderStatus = new OrderStatus(
                        resultSet.getInt("id"),
                        resultSet.getString("status")
                );
                orderStatuses.add(orderStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderStatuses;
    }

    @Override
    public OrderStatus findOne(Integer id) {
        OrderStatus orderStatus = null;
        ResultSet resultSet;
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orderStatus = new OrderStatus(
                        resultSet.getInt("id"),
                        resultSet.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderStatus;
    }

    @Override
    public void create(OrderStatus entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
//            statement.setInt(1, entity.getId());
            statement.setString(1, entity.getStatus());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, OrderStatus entity) {
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
