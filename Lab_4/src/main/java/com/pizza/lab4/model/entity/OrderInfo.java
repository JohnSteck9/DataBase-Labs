package com.pizza.lab4.model.entity;

import java.util.Objects;

public class OrderInfo {
    private Integer id;
    private String comment;
    private Double priceProduct;
    private Double priceDelivery;
    private String expectedTime;
    private String actualTime;
    private Integer deliveryAreaId;
    private Integer orderStatusId;
    private Integer customerId;
    private Integer courierId;


    public OrderInfo(Integer id, String comment, Double priceProduct, Double priceDelivery, String expectedTime,
                     String actualTime, Integer deliveryAreaId, Integer orderStatusId, Integer customerId,
                     Integer courierId ) {
        this.id = id;
        this.comment = comment;
        this.priceProduct = priceProduct;
        this.priceDelivery = priceDelivery;
        this.expectedTime = expectedTime;
        this.actualTime = actualTime;
        this.deliveryAreaId = deliveryAreaId;
        this.orderStatusId = orderStatusId;
        this.customerId = customerId;
        this.courierId = courierId;

    }

    public OrderInfo(String comment, Double priceProduct, Double priceDelivery, String expectedTime, String actualTime,
                     Integer deliveryAreaId, Integer orderStatusId, Integer customerId, Integer courierId ) {
        this(null, comment, priceProduct, priceDelivery, expectedTime, actualTime,
                deliveryAreaId, orderStatusId, customerId, courierId );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrderInfo orderInfo = (OrderInfo) o;
        return Objects.equals(id, orderInfo.id)
                && Objects.equals(comment, orderInfo.comment)
                && Objects.equals(priceProduct, orderInfo.priceProduct)
                && Objects.equals(priceDelivery, orderInfo.priceDelivery)
                && Objects.equals(expectedTime, orderInfo.expectedTime)
                && Objects.equals(actualTime, orderInfo.actualTime)
                && Objects.equals(deliveryAreaId, orderInfo.deliveryAreaId)
                && Objects.equals(orderStatusId, orderInfo.orderStatusId)
                && Objects.equals(customerId, orderInfo.customerId)
                && Objects.equals(courierId, orderInfo.courierId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, priceProduct, priceDelivery, expectedTime, actualTime,
                deliveryAreaId, orderStatusId, customerId, courierId);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id; }

    public String getComment() {
        return comment;
    }
    public void setComment(String comment) { this.comment = comment; }

    public Double getPriceProduct() {
        return priceProduct;
    }
    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Double getPriceDelivery() {
        return priceDelivery;
    }
    public void setPriceDelivery(Double priceDelivery) {
        this.priceDelivery = priceDelivery;
    }

    public String getExpectedTime() {
        return expectedTime;
    }
    public void setExpectedTime(String expectedTime) {
        this.expectedTime = expectedTime;
    }

    public String getActualTime() {
        return actualTime;
    }
    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }

    public Integer getDeliveryAreaId() {
        return deliveryAreaId;
    }
    public void setDeliveryAreaId(Integer deliveryAreaId) { this.deliveryAreaId = deliveryAreaId; }

    public Integer getOrderStatusId() {
        return orderStatusId;
    }
    public void setOrderStatusId(Integer orderStatusId) { this.orderStatusId = orderStatusId; }

    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public Integer getCourierId() {
        return courierId;
    }
    public void setCourierId(Integer courierId) { this.courierId = courierId; }

    @Override
    public String toString() {
        return "Courier{"
                + "id=" + id
                + ", comment=" + comment + '\''
                + ", priceProduct='" + priceProduct + '\''
                + ", priceDelivery='" + priceDelivery + '\''
                + ", expectedTime='" + expectedTime + '\''
                + ", actualTime='" + actualTime + '\''
                + ", deliveryAreaId='" + deliveryAreaId + '\''
                + ", orderStatusId='" + orderStatusId + '\''
                + ", customerId='" + customerId + '\''
                + ", courierId='" + courierId + '\''
                + '}';
    }
}
