package com.pizza.lab4.model.entity;

import java.util.Objects;

public class OrderStatus {
    private Integer orderStatusId;
    private String orderStatus;

    public OrderStatus(Integer orderStatusId, String orderStatus) {
        this.orderStatusId = orderStatusId;
        this.orderStatus = orderStatus;
    }

    public OrderStatus(String orderStatus)  { this(null, orderStatus); }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderStatus that = (OrderStatus) o;
        return Objects.equals(orderStatusId, that.orderStatusId)
                && Objects.equals(orderStatus, that.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatusId, orderStatus);
    }

    public Integer getId() {
        return orderStatusId;
    }
    public void setId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
//    public OrderStatus(String orderStatus)  { this(null, orderStatus); }
    public String getStatus() {
        return orderStatus;
    }
    public void setStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderStatus{"
                + "id=" + orderStatusId
                + ", status='" + orderStatus + '\''
                + '}';
    }
}
