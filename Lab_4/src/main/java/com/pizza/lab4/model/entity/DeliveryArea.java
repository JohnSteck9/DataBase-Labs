package com.pizza.lab4.model.entity;

import java.util.Objects;

public class DeliveryArea {

    private Integer deliveryAreaId;
    private String deliveryZone;
    private String deliveryTime;

    public DeliveryArea(Integer deliveryAreaId, String deliveryZone, String deliveryTime) {
        this.deliveryAreaId = deliveryAreaId;
        this.deliveryZone = deliveryZone;
        this.deliveryTime = deliveryTime;
    }

    public DeliveryArea(String deliveryZone, String deliveryTime) {
        this(null, deliveryZone, deliveryTime);
    }
    public DeliveryArea(String deliveryZone) {
        this(null, deliveryZone, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeliveryArea that = (DeliveryArea) o;
        return Objects.equals(deliveryAreaId, that.deliveryAreaId)
                && Objects.equals(deliveryZone, that.deliveryZone)
                && Objects.equals(deliveryTime, that.deliveryTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryAreaId, deliveryZone, deliveryTime);
    }

    public Integer getId() { return deliveryAreaId; }
    public void setId(Integer deliveryAreaId) {
        this.deliveryAreaId = deliveryAreaId;
    }

    public String getZone() {
        return deliveryZone;
    }
    public void setZone(String deliveryZone) {
        this.deliveryZone = deliveryZone;
    }

    public String getTime() {
        return deliveryTime;
    }
    public void setTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String toString() {
        return "ArtistInformation{"
                + "id=" + deliveryAreaId
                + ", deliveryZone='" + deliveryZone + '\''
                + ", deliveryTime='" + deliveryTime + '\''
                + '}';
    }
}
