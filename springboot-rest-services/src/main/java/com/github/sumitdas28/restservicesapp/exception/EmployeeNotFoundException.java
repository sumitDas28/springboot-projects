package com.github.sumitdas28.restservicesapp.exception;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id) {
        super("No employee found with Id: "+id);
    }
}
