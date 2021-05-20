package com.pizza.lab4.model.entity;

import java.util.Objects;


public class Courier {

    private Integer id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Integer courierStatusId;

    public Courier(Integer id, String firstname, String lastname, String phone, String email, Integer courierStatusId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.courierStatusId = courierStatusId;
    }

    public Courier(String firstname, String lastname, String phone, String email) {
        this(null, firstname, lastname, phone, email, null);
    }

    public int hashCode() { return Objects.hash(id, firstname, lastname, phone, email, courierStatusId); }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(Integer sexId) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String nickname) { this.lastname = lastname; }

    public String getPhone() { return phone; }
    public void setPhone(String name) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String surname) { this.email = email; }

    public Integer getCourierStatusId() { return courierStatusId; }
    public void setCourierStatusId(Integer courierStatusId) { this.courierStatusId = courierStatusId; }

    @Override
    public String toString() {
        return "Courier{"
                + "id=" + id
                + ", firstname='" + firstname + '\''
                + ", lastname='" + lastname + '\''
                + ", phone='" + phone + '\''
                + ", email='" + email + '\''
                + ", courierStatusId='" + courierStatusId + '\''
                + "}\n";
    }
}


    /*
    public Courier(String firstname, String lastname, String phone, String email, Integer courierStatusId) {
        this(null, firstname, lastname, phone, email, courierStatusId);
    }

    @Override
    public String toString() {
        return "\n\nid: " + id + ", firstname: " + firstname + ", lastname: " + lastname
                + ", phone: " + phone + ", email: " + email + ", courierStatusId: " + courierStatusId + "";
    }
    */


