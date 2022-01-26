package com.github.sumitdas28.eas.controller;

import com.github.sumitdas28.eas.model.Employee;
import com.github.sumitdas28.eas.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@BasePathAwareController
@Slf4j
@RequiredArgsConstructor
public class EmployeeController {

    public static final String EMPLOYEE_CREATE_URI = "/employee-admin/employees";

    private final EmployeeRepository repository;

    @PostMapping(value = EMPLOYEE_CREATE_URI, produces = {"application/json", "application/xml"})
    Employee newEmployee(@RequestBody Employee newEmployee, @RequestHeader("Accept") String accept) {
       return repository.save(newEmployee);
    }

//    @PutMapping("/employees/{id}")
//    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }
//
//    @DeleteMapping("/employees/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        repository.deleteById(id);
//    }

}
