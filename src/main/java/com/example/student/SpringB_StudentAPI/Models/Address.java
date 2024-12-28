package com.example.student.SpringB_StudentAPI.Models;

public class Address {
    private String city;

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    private Integer zip;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
