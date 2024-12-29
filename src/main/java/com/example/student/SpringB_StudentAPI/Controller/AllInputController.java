package com.example.student.SpringB_StudentAPI.Controller;

import com.example.student.SpringB_StudentAPI.Models.InputModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class AllInputController {

    //run as : http://localhost:1099/myStudentApi/springFormURLEncoded   -- you need to provide input value form encoded rather param
    @PostMapping("/springFormURLEncoded") //input value will not be displayed in URL.
    public ResponseEntity<String> springFormUrlencoded(Integer id, String name) {
        System.out.println("in spring-form-urlencoded");
        return new ResponseEntity("spring-form-urlencoded : " + id + " - " + name, HttpStatus.OK);
    }

    //using InputModel; Address under input model but manual
    //run as : http://localhost:1099/myStudentApi/springFormURLEncodedX
    @PostMapping("/springFormURLEncodedX") //input value will not be displayed in URL.
    public ResponseEntity<String> springFormUrlencodedX(Integer id, String name, String city, Integer zip) {
        System.out.println("in spring-form-urlencodedX");
        System.out.println( "spring-form-urlencoded under inputModelManual : " + id + " - " + name+ " - "+city+" - "+zip);
        return new ResponseEntity("spring-form-urlencoded under inputModelManual : " + id + " - " + name+ " - "+city+" - "+zip, HttpStatus.OK);
    }



//inputModel
//@PostMapping(value="/springFormURLEncodedXX",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @PostMapping(value="/springFormURLEncodedXX")

   //1.  public ResponseEntity<String> springFormUrlencodedXX( @RequestBody InputModel inputModel) {
      //public ResponseEntity<InputModel> springFormUrlencodedXX( @RequestBody InputModel inputModel) {    //best to use ? rather any inputmodel or string or something
      public ResponseEntity<?> springFormUrlencodedXX( @RequestBody InputModel inputModel) {
          System.out.println("in spring-pojo example using InputModel");
    System.out.println( "spring-pojo example form-urlencoded under inputModel : " +inputModel);//inputModel.getAddress()); //?
 //1.   return new ResponseEntity<String>("spring-form-urlencoded under inputModelManual : " + inputModel.getId() + " - " + inputModel.getName()+ " - "+inputModel.getAddress().getCity()+" - "+inputModel.getAddress().getZip(), HttpStatus.OK);
   //  return new ResponseEntity<InputModel>("Spring json returned: inputModelProg : " + inputModel, HttpStatus.OK); //Don't type any string else inputModel will internally become string.
      return new ResponseEntity<>( inputModel, HttpStatus.OK);
    }

}
