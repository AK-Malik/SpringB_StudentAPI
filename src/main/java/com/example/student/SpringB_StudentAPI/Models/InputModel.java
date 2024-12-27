package com.example.student.SpringB_StudentAPI.Models;

public class InputModel {
    private Integer Id;
    private String Name;

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

    @Override
    public String toString() {
        //  return getClass().getName() + "@" + Integer.toHexString(hashCode());
        return "InputModel [  Id:= "+Id+" , Name= "+Name+" ]";
    }
}