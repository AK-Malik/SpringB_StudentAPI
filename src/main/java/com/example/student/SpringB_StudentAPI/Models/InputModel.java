package com.example.student.SpringB_StudentAPI.Models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
public class InputModel {
    private Integer Id;
    private String Name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
                      //  private String DOB;
                      public Date getDob() {
                          return dob;
                      }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    private Address address;

    //private List<String> list;
    //private Map<Integer,String> map;
    //private List<Subject> listSubject;

    public Integer getId() {
        return Id;
    } //use camel convention id
    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }


    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    //This is not needed but extra to print object. this is only useful for logging/printing


    @Override
    public String toString() {
        return "InputModel{" +
                "Id=: " + Id +
                ", Name=: '" + Name + '\'' +
                ", dob=: " + dob +
                ", address=: " + address +
                '}';
    }
}
// list, map, to make little more complex in it.
//create mini model a separate model.
//add Java date as class variable like int/ private Date DoB ;