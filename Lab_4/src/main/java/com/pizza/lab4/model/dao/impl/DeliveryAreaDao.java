package com.pizza.lab4.model.dao.impl;

import static com.pizza.lab4.util.DatabaseConnector.getConnection;
import com.pizza.lab4.model.dao.AbstractDao;
import com.pizza.lab4.model.entity.DeliveryArea;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DeliveryAreaDao implements AbstractDao<DeliveryArea>{

    private static final String GET_ALL_QUERY = "SELECT * FROM pizza_project.delivery_area;";
    private static final String GET_ONE_QUERY = "SELECT * FROM pizza_project.delivery_area "
            + "WHERE id = ?;";
    private static final String CREATE_QUERY = "INSERT INTO pizza_project.delivery_area "
            + "(zone) VALUES (?);";
    private static final String UPDATE_QUERY = "UPDATE pizza_project.delivery_area "
            + "SET zone = ? WHERE id = ?;";
    private static final String DELETE_QUERY = "DELETE FROM pizza_project.delivery_area "
            + "WHERE id = ?;";

    @Override
    public ArrayList<DeliveryArea> findAll() {
        ArrayList<DeliveryArea> deliveryAreas = new ArrayList<>();

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet = statement.executeQuery(GET_ALL_QUERY)) {
            while (resultSet.next()) {
                DeliveryArea deliveryArea = new DeliveryArea(
                        resultSet.getInt("id"),
                        resultSet.getString("zone"),
                        resultSet.getString("delivery_time")
                );
                deliveryAreas.add(deliveryArea);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryAreas;
    }

    @Override
    public DeliveryArea findOne(Integer id) {
        DeliveryArea deliveryArea = null;
        ResultSet resultSet;
        try (PreparedStatement statement = getConnection().prepareStatement(GET_ONE_QUERY)) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                deliveryArea = new DeliveryArea(
                        resultSet.getInt("id"),
                        resultSet.getString("zone"),
                        resultSet.getString("delivery_time")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryArea;
    }

    @Override
    public void create(DeliveryArea entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(CREATE_QUERY)) {
//            statement.setInt(1, entity.getId());
            statement.setString(1, entity.getZone());
//            statement.setString(2, entity.getTime());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, DeliveryArea entity) {
        try (PreparedStatement statement = getConnection().prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, entity.getZone());
//            statement.setString(1, entity.getTime());
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
