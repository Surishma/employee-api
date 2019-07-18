package com.employee.controller;

import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

   @Autowired
   private EmployeeRepository employeeRepository;


    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployee(@RequestParam(value="firstName",required=false) String firstName,
                                                      @RequestParam(value="lastName",required=false) String lastName){
       List<Employee> employees = employeeRepository.getEmployeeByName(firstName,lastName);
        return new ResponseEntity<>(employees,HttpStatus.OK);

    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addEmployee(@RequestBody Employee employee){
        employeeRepository.createEmployee(employee);
        return new ResponseEntity(HttpStatus.OK);

    }

     /*@RequestMapping(value = "/employee", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("Surishma");
        employee.setLastName("Loka");
        employee.setDob(new Date());
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }*/



}



