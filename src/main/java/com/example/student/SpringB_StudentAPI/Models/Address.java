package com.example.student.SpringB_StudentAPI.Models;

public class Address {
    private String city;
    private Integer zip;

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Integer getZip() {
        return zip;
    }
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    @Override
    public String toString ()
    {
         System.out.println ("Entered value of City is : "+city+ ", zip is: "+ zip);
         return "Address" +city+", "+zip;
    }
}
