package com.example.student.SpringB_StudentAPI.ModelsCreateDef;

import com.example.student.SpringB_StudentAPI.Models.Address;
import com.example.student.SpringB_StudentAPI.Models.InputModel;

import java.time.format.DateTimeFormatter;

public class CreateModelDef {
        public static InputModel createInputModel() {
        Address address1 = new Address();
        address1.setCity("Panipat");
        address1.setZip(132103);

        InputModel inputModelX = new InputModel();
        inputModelX.setId(123);
        inputModelX.setName("NeelG Haryana Wale");
      //  inputModel.setdob("1984-12-1");
       // String sdate ="1984-03-03";
      //  inputModel.setDOB.LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        //return new CreateModelDef();

         inputModelX.setAddress(address1);
        return inputModelX;
    }
    /*
    public static CreateModelDef getCreateModelDef()
    {


        System.out.println("under CreateModelDef class: "+);

    }*/
}