package com.sumit.learnjava.restapi.client.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumit.learnjava.restapi.client.model.Employee;
import com.sumit.learnjava.restapi.client.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		EmployeeService service = new EmployeeService();
		return new ResponseEntity<Employee>(service.addEmployee(employee), HttpStatus.OK);
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		EmployeeService service = new EmployeeService();
		return new ResponseEntity<List<Employee>>(service.getAllEmployees(), HttpStatus.OK);
	}

}
