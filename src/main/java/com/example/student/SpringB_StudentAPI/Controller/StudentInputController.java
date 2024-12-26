package com.example.student.SpringB_StudentAPI.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class StudentInputController {

    /*  1.
    Run as: http://localhost:1099/getStudentId in postman, if no server.servlet.context-path is set ( default way of running)
    Run as: http://localhost:1099/myStudentApi/getStudentId  , if context-path is set as /myStudentApi under resource/application.properties
     */
    @GetMapping("/getStudentId")
    public String getStudentId() {
        System.out.println("I'm under /getStudentId method, will be printed in logs");
        return "Get the Student ID"; //will be displayed in response under get call in postman
    }

    private static final Logger logger = Logger.getLogger(StudentInputController.class.getName()); //extra not needed

    /* 2. Query-Param Example
     * GET --> http://localhost:1099/myStudentApi/getStudentNameByIdiInQueryParam?Id=1
     * Both are mandatory
     * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     */
    @GetMapping("/getStudentNameByIdiInQueryParam")   // Or
    //  @RequestMapping(value = "/getStudentNameByIdiInQueryParam", method = RequestMethod.GET)  //replaced now by @GetMapping

    public ResponseEntity<?> studentName(@RequestParam(value = "Id", required = true) Integer Id) //Or //what if String Id.
    //  public ResponseEntity<String> studentName(@RequestParam(value = "Id", required = true) Integer Id, HttpServletRequest request) //replaced by above now
    {
        logger.info("This is an informational message."); //extra not needed just trial
        //  logger.warning("This is an informational message."); //logger.severe("This is an informational message.");
        System.out.println("Printing the name of student for {Id}: " + Id);
       // return new ResponseEntity<String>("Student Name for {Id} " + Id + " is: Fetched", HttpStatusCode.valueOf(200));
          return new ResponseEntity<>("Student Name for {Id} " + Id + " is: Fetched", HttpStatusCode.valueOf(200));

        //return new ResponseEntity("spring-querystring :: " + id + " - " + name, HttpStatus.OK);
    }

    //try the below as well - simple flavour
    @GetMapping("/getStudentNameByIdiInQueryParams")
    //public ResponseEntity<String> studentIdName(@RequestParam(value = "Id", required = true) Long Id1 ) {
    // return new ResponseEntity<String> ("Id="+Id, HttpStatusCode.valueOf(200)); //or
    public String studentIdName(@RequestParam(name = "Id", required = true) Long Id1) {
        return "Id =" + Id1;
    }

    //2. post -> send student_id, student_name in form of request param, response will be a string with value "INSERTED" and code 201

    /* 2. Request-Param Example
     * Post --> http://localhost:1099/myStudentApi/getStudentNameByIdiInQueryParamss?S_Id=1234&S_Name=Anil
     * Both are mandatory
     * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     * Check this once. Post --> http://localhost:1099/myStudentApi/getStudentNameByIdiInQueryParamss?ID=1&Name=Anil
     * */

    @PostMapping("/getStudentNameByIdiInQueryParamss")
    public ResponseEntity<String> studentIDName(
            @RequestParam(value = "S_Id", defaultValue = "12345") Long S_Id, @RequestParam(value = "S_Name", required = false) String Name) {
        System.out.println("Entered Values are: " + S_Id + " , " + Name);
        logger.warning("This is an info message.");
        return new ResponseEntity<>("S_Id=" + S_Id + " and " + "S_Name= " + Name + ", Record got INSERTED", HttpStatusCode.valueOf(201));
    }

    //3. put -> send student_id in form of path variable, response will be a string with value "UPDATED" and code 204

    //Run As : http://localhost:1099/myStudentApi/sendStudentIDAsPathvariable/123/NeelG . No content will be displayed due to httpcode:204
    @PutMapping("/sendStudentIDAsPathvariable/{Id}/{Name}")
    public ResponseEntity<String> putStudentIdName(
            @PathVariable(value = "Id", required = true) Integer Id,
            @PathVariable(name = "Name") String Name) {
        System.out.println("Input spring-path-params are: " + Id + " , " + Name);
        return new ResponseEntity<String>("Id: " + Id + " , Name:  " + Name + " , Value got UPDATED", HttpStatus.valueOf(204));
    }

    /*
     * GET --> http://localhost:1099/myStudentAPI/spring-pathParam/123/neelG
     * Both are mandatory, no key names required, only values required
     * If any one of them is not provided then exception will be thrown with 404(Not Found) as ResponseCode
     */
    @GetMapping("/spring-pathParam/{id}/{name}")
    //{id} will be like /1 and {name} like AK
    public ResponseEntity<String> springPathParam(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        System.out.println("spring-pathParam");
        return new ResponseEntity("spring-pathParam : " + id + " - " + name, HttpStatusCode.valueOf(200));
    }

    //4. Run As : http://localhost:1099/myStudentApi/sendStudentIDAsPathVariableDelete?Id=123&Name=NeelG . No content will be displayed due to httpcode:204
    @DeleteMapping("/sendStudentIDAsPathVariableDelete")
    public ResponseEntity<String> putStudentIdNames(
            @RequestParam(value = "Id", required = true) Integer Id,
            @RequestParam(name = "Name") String Name) {
        System.out.println("Input spring-path-params are: " + Id + " , " + Name);
        return new ResponseEntity<String>("Id: " + Id + " , Name:  " + Name + " , Value got Deleted", HttpStatus.valueOf(200));//204
    }

}
