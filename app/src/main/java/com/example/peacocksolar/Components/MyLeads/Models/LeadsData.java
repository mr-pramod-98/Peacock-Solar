package com.example.peacocksolar.Components.MyLeads.Models;

public class LeadsData {
    int id, pincode;
    String customer_name, address, phone_no, city, state;

    public LeadsData(int id, int pincode, String customer_name, String address, String phone_no, String city, String state) {
        this.id = id;
        this.pincode = pincode;
        this.customer_name = customer_name;
        this.address = address;
        this.phone_no = phone_no;
        this.city = city;
        this.state = state;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public int getPincode() {
        return pincode;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    // SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}
