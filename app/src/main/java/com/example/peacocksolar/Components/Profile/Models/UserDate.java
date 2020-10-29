package com.example.peacocksolar.Components.Profile.Models;

public class UserDate {
    private String name, phone_no, email, gender, dob;
    private int id;

    public UserDate(int id, String name, String email, String phone_no, String gender, String dob) {
        this.id = id;
        this.name = name;
        this.phone_no = phone_no;
        this.email = email;
        this.gender = gender;
        this.dob = dob;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phone_no;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dob;
    }

    public int getId() {
        return id;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phone_no) {
        this.phone_no = phone_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dob) {
        this.dob = dob;
    }

    public void setId(int id) {
        this.id = id;
    }
}
