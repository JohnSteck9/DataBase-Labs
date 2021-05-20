package com.pizza.lab4.model.entity;

import java.util.Objects;

public class Customer {
    private Integer id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;

    public Customer(Integer id, String firstname, String lastname, String phone, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
    }

    public Customer(String firstname, String lastname, String phone, String email) {
        this(null, firstname, lastname, phone, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id)
                && Objects.equals(firstname, customer.firstname)
                && Objects.equals(lastname, customer.lastname)
                && Objects.equals(phone, customer.phone)
                && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, phone, email);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) { this.id = id; }

    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() { return lastname; }
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Courier{"
                + "id=" + id
                + ", firstname=" + firstname
                + ", lastname='" + lastname + '\''
                + ", phone='" + phone + '\''
                + ", email='" + email + '\''
                + '}';
    }
}
