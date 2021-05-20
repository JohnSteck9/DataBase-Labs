package com.pizza.lab4.model.dao.impl;

import static com.pizza.lab4.util.DatabaseConnector.getConnection;
import com.pizza.lab4.model.dao.AbstractDao;
import com.pizza.lab4.model.entity.OrderInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderInfoDao implements AbstractDao<OrderInfo> {

    private static final String GET_ALL_QUERY = "SELECT * FROM pizza_project.order_info;";
    private static final String GET_ONE_QUERY = "SELECT * FROM pizza_project.order_info "
            + "WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO pizza_project.order_info "
            + "(order_comment, price_product, price_delivery, expected_time, actual_time, "
            + "delivery_area_id, order_status_id, customer_id, courier_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_QUERY = "UPDATE pizza_project.order_info "
            + "SET order_comment = ?, price_product = ?,  price_delivery = ?,  expected_time = ?,  actual_time = ?, "
            + "delivery_area_id = ?, order_status_id = ?, customer_id = ?, courier_id = ? "
            + "WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM pizza_project.order_info "
            + "WHERE id = ?;";

    @Override
    public ArrayList<OrderInfo> findAll() {
        ArrayList<OrderInfo> orderInfos = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY)) {
            while (resultSet.next()) {
                OrderInfo orderInfo = new OrderInfo(
                        resultSet.getInt("id"),
                        resultSet.getString("order_comment"),
                        resultSet.getDouble("price_product"),
                        resultSet.getDouble("price_delivery"),
                        resultSet.getString("expected_time"),
                        resultSet.getString("actual_time"),
                        resultSet.getInt("delivery_area_id"),
                        resultSet.getInt("order_status_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("courier_id")
                );
                orderInfos.add(orderInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderInfos;
    }

    @Override
    public OrderInfo findOne(Integer id) {
        OrderInfo orderInfo = null;
        ResultSet resultSet;
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                orderInfo = new OrderInfo(
                        resultSet.getInt("id"),
                        resultSet.getString("order_comment"),
                        resultSet.getDouble("price_product"),
                        resultSet.getDouble("price_delivery"),
                        resultSet.getString("expected_time"),
                        resultSet.getString("actual_time"),
                        resultSet.getInt("delivery_area_id"),
                        resultSet.getInt("order_status_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getInt("courier_id")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderInfo;
    }

    @Override
    public void create(OrderInfo entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
            statement.setString(1, entity.getComment());
            statement.setDouble(2, entity.getPriceProduct());
            statement.setDouble(3, entity.getPriceDelivery());
            statement.setString(4, entity.getExpectedTime());
            statement.setString(5, entity.getActualTime());
            statement.setInt(6, entity.getDeliveryAreaId());
            statement.setInt(7, entity.getOrderStatusId());
            statement.setInt(8, entity.getCustomerId());
            statement.setInt(9, entity.getCourierId());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, OrderInfo entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, entity.getComment());
            statement.setDouble(2, entity.getPriceProduct());
            statement.setDouble(3, entity.getPriceDelivery());
            statement.setString(4, entity.getExpectedTime());
            statement.setString(5, entity.getActualTime());
            statement.setInt(6, entity.getDeliveryAreaId());
            statement.setInt(7, entity.getOrderStatusId());
            statement.setInt(8, entity.getCustomerId());
            statement.setInt(9, entity.getCourierId());
            statement.setInt(10, id);

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
