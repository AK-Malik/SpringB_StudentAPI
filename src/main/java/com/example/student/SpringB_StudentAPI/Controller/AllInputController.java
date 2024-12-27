package com.example.student.SpringB_StudentAPI.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AllInputController {

    //run as : http://localhost:1099/myStudentApi/springFormURLEncoded   -- you need to provide input value form encoded rather param
    @PostMapping("/springFormURLEncoded") //input value will not be displayed in URL.
    public ResponseEntity<String> springFormUrlencoded(Integer id, String name) {
        System.out.println("in spring-form-urlencoded");
        return new ResponseEntity("spring-form-urlencoded : " + id + " - " + name, HttpStatus.OK);
    }

}
