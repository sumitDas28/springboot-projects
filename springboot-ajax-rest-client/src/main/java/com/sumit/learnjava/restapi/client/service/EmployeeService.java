package com.sumit.learnjava.restapi.client.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sumit.learnjava.restapi.client.model.Employee;

@Service
public class EmployeeService {

	public Employee addEmployee(Employee employee) {
		final String uri = "http://localhost:8181/cxf/learnjava/api/employees";
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(uri, employee, Employee.class);
		return result;
	}

	public List<Employee> getAllEmployees() {
		final String uri = "http://localhost:8181/cxf/learnjava/api/employees";
		RestTemplate restTemplate = new RestTemplate();
		Employee[] result = restTemplate.getForObject(uri, Employee[].class);
		return Arrays.asList(result);
	}
}
