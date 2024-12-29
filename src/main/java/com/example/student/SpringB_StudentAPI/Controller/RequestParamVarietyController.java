package com.example.student.SpringB_StudentAPI.Controller;

import com.example.student.SpringB_StudentAPI.Models.InputModel;
import com.example.student.SpringB_StudentAPI.ModelsCreateDef.CreateModelDef;
import jakarta.servlet.ServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestParamVarietyController {

    /*
     * Hit with : id = 11 name = ANILKUMAR,
     * POST --> http://localhost:1099/myStudentApi/request-param-with-diff-name and provide param as id and name or
     * run as : http://localhost:1099/myStudentApi/request-param-with-diff-name?id=123&name=Anil
     * Both are mandatory
     * If any one of them is not provided then exception will be thrown with 400(Bad Request) or 404 as ResponseCode
     * Key names should be strictly id and name
     * RequestParam variables differ, IDdummy for id and NAMEdummy for name
     */
    @PostMapping("/request-param-with-diff-name")
    public ResponseEntity<String> requestParamWithDiffNames(@RequestParam("id") String IDdummy, @RequestParam("name") String NAMEdummy) {
        System.out.println("in requestParamWithDiffNames");
        return new ResponseEntity("requestParamWithDiffNames: " + IDdummy + " - " + NAMEdummy, HttpStatus.OK);
    }

    /*
     * Hit with : id = 1 name = Anil,
     * Get --> http://localhost:1099/myStudentApi/request-param-with-same-name
     * Type in postman under param, give id = 1 and name = anil   or
     * http://localhost:1099/myStudentApi/request-param-with-same-name?id=123&name=Anil
     * Both are mandatory
     * If any one of them is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     */
    @GetMapping("/request-param-with-same-name")
    public ResponseEntity<String> requestParamWithSameNames(@RequestParam String id, @RequestParam String name) {
        System.out.println("in requestParamWithSameNames");
        return new ResponseEntity("requestParamWithSameNames: " + id + " - " + name, HttpStatus.OK);
    }

    /*
     * Hit with : id = 1 name = Anil,
     * POST --> http://localhost:1099/myStudentApi/request-param-mandatory-value
     * Only id is mandatory
     * If id is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     * If name is not provided null is assigned to RequestParam variable name
     */
    @PostMapping("/request-param-mandatory-value")  //default takes true as seen in below
    public ResponseEntity<String> requestParamMandatoryValue(@RequestParam String id, @RequestParam(required = false) String name) {
        System.out.println("in requestParamMandatoryValue");
        return new ResponseEntity("requestParamMandatoryValue: " + id + " - " + name, HttpStatus.OK);
    }

    @PostMapping("/request-param-mandatory-value1")
    public ResponseEntity<String> requestParamMandatoryValue1(@RequestParam(required = true) String id, @RequestParam(required = false) String name) {
        System.out.println("in requestParamMandatoryValue");
        return new ResponseEntity("requestParamMandatoryValue: " + id + " - " + name, HttpStatus.OK);
    }

    /*
     * Hit with : id = 1 name = anil,
     * POST --> http://localhost:1099/myStudentApi/request-param-default-value
     * Only id is mandatory
     * http://localhost:1099/myStudentApi/request-param-default-value?id=12&name=
     * If id is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     * If name is not provided "Sumita" is assigned as default value to RequestParam variable name
     */
    @PostMapping("/request-param-default-value")
    public ResponseEntity<String> requestParamDefaultValue(@RequestParam String id, @RequestParam(required = false, defaultValue = "Sumita") String name) {
        System.out.println("in requestParamDefaultValue");
        return new ResponseEntity("requestParamDefaultValue: " + id + " - " + name, HttpStatus.OK);
    }

    /*
     * Hit with : id = 1 name = Anil,
     * POST --> http://localhost:1099/myStudentApi/request-param-with-all-attributes
     * Only id is mandatory
     * If id is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key names should be strictly id and name
     * RequestParam variable differs, nameDummy for name
     * If name is not provided "BabyAnil" is assigned as default value to RequestParam variable name
     */
    @PostMapping("/request-param-with-all-attributes")
    //value or name ir id all are same as below. if you provide name =anilkumar, it will take this first rather default.
    public ResponseEntity<String> requestParamWithAllAttributes(@RequestParam String id, @RequestParam(value = "name", required = false, defaultValue = "babyAnil") String nameDummy) {
        System.out.println("in requestParamWithAllAttributes");
        return new ResponseEntity("requestParamWithAllAttributes: " + id + " - " + nameDummy, HttpStatus.OK);
    }

    /* List
     * Hit with : nameList = AK, nameList = Anil, nameList = Kumar, nameList = Sumita, nameList = Ram
     * POST --> http://localhost:1099/myStudentApi/request-param-multi-values-mandatory
     * nameList is mandatory
     * If nameList is not provided then exception will be thrown with 400(Bad Request) as ResponseCode
     * Key name should be nameList
     */
    @PostMapping("/request-param-multi-values-mandatory")
    //params.  http://localhost:1099/myStudentApi/request-param-multi-values-mandatory?nameList=A&nameList=B
    public ResponseEntity<String> requestParamMultiValuesMandatory(@RequestParam List<String> nameList) {
        System.out.println("in requestParamMultiValuesMandatory");
        return new ResponseEntity("requestParamMultiValuesMandatory: " + nameList, HttpStatusCode.valueOf(200));
    }

    //Run As Get : http://localhost:1099/myStudentApi/multivariableusinglist?mlist=A&mlist=B&mlist=Ram&mlist=NeelG - see response [ "A", "B"]
    @GetMapping("/multivariableusinglist")
    public ResponseEntity<List> mylist(@RequestParam List<String> mlist)  //List<String> //List<List> - check answer
    {
        System.out.println("multivalue list here");
        return new ResponseEntity<>(mlist, HttpStatus.OK);
    }


    /*
     * Hit with : nameList = A, nameList = B, nameList = C, nameList = D, nameList = E
     * POST --> http://localhost:1099/myStudentApi/request-param-multi-values-default
     * nameList is optional
     * If nameList is not provided then "Anil, Kumar, Malik" will be implicitely converted to List<String>, this depends on the "referenced by datatype",
     * if datatype is List<String> then "Anil, Kumar, Malik" wil be converted to List
     * if datatype is String then "Anil, Kumar, Malik" will be regarded as single string
     * Key name should be nameList
     */
    @PostMapping("/request-param-multi-values-default")
    public ResponseEntity<String> requestParamMultiValuesDefault(@RequestParam(required = false, defaultValue = "Anil, Kumar, Malik") List<String> nameList) {
        System.out.println("in requestParamMultiValuesDefault");
        return new ResponseEntity("requestParamMultiValuesDefault: " + nameList, HttpStatus.OK);
    }

    //AK extra practice
    //Run as : http://localhost:1099/myStudentApi/displayNamesDefinedbyAK?names=A&names=B&names=Ram&names=NeelG   or
    //Run as http://localhost:1099/myStudentApi/displayNamesDefinedbyAK?
    @PostMapping("/displayNamesDefinedbyAK")
    //public ResponseEntity<String> myTestMethodWithRequestParam(@RequestParam (required = true, value = "names", defaultValue ="Anil, Kumar, Malik" ) String DisplayNames)
    public ResponseEntity<String> myTestMethodWithRequestParam(@RequestParam(required = true, value = "names", defaultValue = "Anil, Kumar, Malik") List<String> DisplayNames) {
        System.out.println("Display myTestMethodWithRequestParam with Name String");
        return new ResponseEntity<>("Given names printed as: " + DisplayNames, HttpStatus.OK);
    }

    //Matrix Variable  . use MAp
    //run as : http://localhost:1099/myStudentApi/matrixParam  or
    // run as : http://localhost:1099/myStudentApi/matrixParam/data;id=2;name=abc;id=3;name=bcd;name=anil;name=sk - Y Id once?
    @GetMapping("/matrixParam/{add}")  //what if I dont use {data} and use {add} - not working.
    public ResponseEntity<String> matrix(                        //use Map with key value pair
                                                                 @MatrixVariable(value = "id", required = true, defaultValue = "123") List<Integer> id,  //remove List
                                                                 @MatrixVariable(value = "name", defaultValue = "NeelG") List<String> name) {
        System.out.println("Printing matrix param: " + id + " : " + name);
        return new ResponseEntity<>("Matrix param entered are:" + id + ": " + name, HttpStatusCode.valueOf(200));
    }

    /* JSON  thru Model
     * POST --> http://localhost:1099/myStudentApi/SpringJSONTest   //based in input model (id, name only)
     * Hit with JSON format of SuperModel object
     * If JSON body is not provided then exception will be thrown with 415(unsupported Media Type) as ResponseCode
     * If some fields are missing from JSON body and its a valid JSON, then the JSON will be absorbed but the missing fields will be assigned as null
     */         // name and value both are acceptable. if u r using multi argument using annotation, then use keyname mandatory, for single argument, just mention end point without name/value, it will work ..
    @PostMapping(value = "/SpringJSONTest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InputModel> springJSON(ServletRequest request, @RequestBody InputModel inputModel) {
        System.out.println("springJSONTest: " + inputModel);

        // Exception test
        return new ResponseEntity<InputModel>(inputModel, HttpStatus.OK);  //also works with: return new ResponseEntity(InputModel,HttpStatus.OK);
    }


    //from Input model using JSON format in request body
    @PostMapping(value = "/fromInputModelThruJson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) //runs without as well
    //input value will not be displayed in URL.
    public ResponseEntity<String> springInputModelPojo( @RequestBody InputModel inputmodel) { //if you intercept Json you need @Requestbody annotation
        System.out.println("fromInputModel pojo");
        System.out.println("Json inputModelManual : " + inputmodel);
        return new ResponseEntity(inputmodel, HttpStatus.OK);
    }

    //from Input model - internal but without @RequestBody
    @PostMapping(value = "/fromInputModelThruJsoWithoutRequestBody", produces = MediaType.APPLICATION_JSON_VALUE) //runs without as well
    //input value will not be displayed in URL.
    public ResponseEntity<?> springInputModelPojoWithoutRequestBody( ) {
        System.out.println("fromInputModel pojo without request body as input");
        System.out.println("Json inputModel without request body as input- AK : " + CreateModelDef.createInputModel()); //just for logging
        return new ResponseEntity<>(CreateModelDef.createInputModel() ,HttpStatus.OK);
    }



}


//This Controller details all the features of @RequestParam, its different attributes(value, required, defaultValue)
