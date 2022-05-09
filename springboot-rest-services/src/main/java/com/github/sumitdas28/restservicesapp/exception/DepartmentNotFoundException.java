package com.github.sumitdas28.restservicesapp.exception;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException() {
        super("no department found");
    }

    public DepartmentNotFoundException(Long id) {
        super("No department found with Id: "+id);
    }
}
