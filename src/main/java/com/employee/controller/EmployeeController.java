package com.employee.controller;

import com.employee.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("Surishma");
        employee.setLastName("Loka");
        employee.setDob(new Date());
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }
}



