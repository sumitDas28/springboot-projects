package com.github.sumitdas28.restservicesapp.controller;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.github.sumitdas28.restservicesapp.exception.EmployeeNotFoundException;
import com.github.sumitdas28.restservicesapp.model.Employee;
import com.github.sumitdas28.restservicesapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public ResponseEntity<CollectionModel<Employee>> getAllEmployees(){
        try{
            List<Employee> employees = employeeRepository.findAll();
            for(Employee employee: employees){
                Long id = employee.getId();
                Link selfLink = linkTo(EmployeeController.class).slash(id).withSelfRel();
                employee.add(selfLink);
            }
            Link link = linkTo(EmployeeController.class).withSelfRel();
            CollectionModel<Employee> result = CollectionModel.of(employees,link);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Oops! something went wrong...",e);
        }
    }

    @PostMapping
    public ResponseEntity<EntityModel<Employee>> createNewEmployee(@Valid @RequestBody Employee employee){
       try{
           Employee createdEmployee = employeeRepository.save(employee);
           Link link = linkTo(EmployeeController.class).slash(createdEmployee.getId()).withSelfRel();
           EntityModel<Employee> result = EntityModel.of(createdEmployee,link);
           return new ResponseEntity<>(result, HttpStatus.CREATED);
       } catch(Exception e){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Oops! something went wrong...",e);
       }

    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Employee>> getEmployeeById(@PathVariable Long id) throws Exception {
        try{
            var employee = employeeRepository.findById(id);
            if(employee.isPresent()){
                Link link = linkTo(EmployeeController.class).slash(employee.get().getId()).withSelfRel();
                EntityModel<Employee> result = EntityModel.of(employee.get(),link);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else{
                throw new EmployeeNotFoundException(id);
            }
        } catch (EmployeeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No employee found with Id:"+id,e);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Oops! something went wrong...",e);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<Employee>> updateEmployee(@Valid @RequestBody Employee newEmployee, @PathVariable Long id) throws Exception {
        try {
            return employeeRepository.findById(id).map(employee -> {
                if(newEmployee.getName()!=null && newEmployee.getName().length()>0)employee.setName(newEmployee.getName());
                if(newEmployee.getRole()!=null && newEmployee.getRole().length()>0)employee.setRole(newEmployee.getRole());
                var updatedEmployee = employeeRepository.save(employee);
                Link link = linkTo(EmployeeController.class).slash(updatedEmployee.getId()).withSelfRel();
                EntityModel<Employee> result = EntityModel.of(updatedEmployee,link);
                return new ResponseEntity<>(result, HttpStatus.OK);
            }).orElseThrow(() -> new EmployeeNotFoundException(id));
        } catch (EmployeeNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No employee found with Id:"+id,e);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Oops! something went wrong...",e);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        try{
            employeeRepository.deleteById(id);
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"Oops! something went wrong...",e);
        }
    }
}
