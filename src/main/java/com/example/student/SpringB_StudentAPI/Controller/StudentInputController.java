package com.example.student.SpringB_StudentAPI.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class StudentInputController {

  /*
  Run as: http://localhost:1099/getStudentId in postman, if no server.servlet.context-path is set ( default way of running)
  Run as: http://localhost:1099/myStudentApi/getStudentId  , if context-path is set under resource/application.properties
   */

    @GetMapping("/getStudentId")
    public String getStudentId()
    {
        System.out.println("I'm under /getStudentId method, will be printed in logs");
        return "Get the Student ID"; //will be displayed in response under get call in postman
    }

    /*
     * GET --> http://localhost:1099/myStudentApi/getStudentNameByIdiInQueryParam?id=1&name=NeelG
     * Both are mandatory
     * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     */
    Logger logger = new Logger();
    @GetMapping("/getStudentNameByIdiInQueryParam")
    //Run as: http://localhost:1099/myStudentApi/getStudentNameByIdiInQueryParam?Id=1
   // @RequestMapping(value = "/getStudentNameByIdiInQueryParam", method = RequestMethod.GET)

    public ResponseEntity<String> studentName(@RequestParam(value = "Id", required = true) Integer Id, HttpServletRequest request)
    {

        System.out.println("Printing the name of student for {Id}: " +Id) ;
      //  try{
        //    if (id is not present in DB return error else print name)
        //}catch(Exception e){}
        return new ResponseEntity<String> ("Student Name for {Id} " +Id+ " is: Fetched", HttpStatusCode.valueOf(200));
        //return new ResponseEntity("spring-querystring :: " + id + " - " + name, HttpStatus.OK);
    }


}
