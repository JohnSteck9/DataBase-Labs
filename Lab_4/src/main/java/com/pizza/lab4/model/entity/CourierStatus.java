package com.pizza.lab4.model.entity;

import java.util.Objects;

public class CourierStatus {
    private Integer courierStatusId;
    private String courierStatus;

    public CourierStatus(Integer courierStatusId, String courierStatus) {
        this.courierStatusId = courierStatusId;
        this.courierStatus = courierStatus;
    }

    public CourierStatus(String courierStatus) { this(null, courierStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CourierStatus that = (CourierStatus) o;
        return Objects.equals(courierStatusId, that.courierStatusId)
                && Objects.equals(courierStatus, that.courierStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courierStatusId, courierStatus);
    }

    public Integer getId() {
        return courierStatusId;
    }
    public void setId(Integer courierStatusId) {
        this.courierStatusId = courierStatusId;
    }

    public String getStatus() {
        return courierStatus;
    }
    public void setStatus(String courierStatus) {
        this.courierStatus = courierStatus;
    }

    @Override
    public String toString() {
        return "ArtistInformation{"
                + "id=" + courierStatusId
                + ", courierStatus='" + courierStatus + '\''
                + "}\n";
    }
}
