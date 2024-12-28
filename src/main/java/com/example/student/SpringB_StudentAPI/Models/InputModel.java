package com.example.student.SpringB_StudentAPI.Models;

import java.util.Date;

public class InputModel {
    private Integer Id;
    private String Name;
    private Date DOB;
    private Address address;

    //private List<String> list;
    //private Map<Integer,String> map;
    //private List<Subject> listSubject;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public Date getDOB() {
        return DOB;
    }
    public void setDOB(Date DOB) {
        this.DOB = DOB;
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
        //  return getClass().getName() + "@" + Integer.toHexString(hashCode());
       //return "InputModel [  Id:= "+Id+" , Name= "+Name+" ]";
        return "Anil";
    }
}
// list, map, to make little more complex in it.
//create mini model a separate model.
//add Java date as class variable like int/ private Date DoB ;