package com.pizza.dto;


public class CourierDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Integer courierStatusId;

    public CourierDTO(Integer id, String firstName, String lastName, String phone, String email,
                      Integer courierStatusId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.courierStatusId = courierStatusId;
    }

    public CourierDTO() {
    }


    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getCourierStatusId() {
        return courierStatusId;
    }
    public void setCourierStatusId(int courierStatusId) {
        this.courierStatusId = courierStatusId;
    }


}
