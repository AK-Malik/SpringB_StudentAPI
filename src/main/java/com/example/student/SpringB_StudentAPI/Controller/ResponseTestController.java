package com.example.student.SpringB_StudentAPI.Controller;

import com.example.student.SpringB_StudentAPI.Models.Address;
import com.example.student.SpringB_StudentAPI.Models.InputModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/*
@RestController
public class ResponseTestController {
/*
	@PostMapping(value="test", produces="application/json")
	public ResponseEntity<Address> testMethod(){
		System.out.println("Hit");
		Address model = new Address();
		model.setCity("Bridgewater");
		model.setZip(8807);
		return new ResponseEntity<Address>(model, HttpStatus.valueOf(301));
	}
}
*/