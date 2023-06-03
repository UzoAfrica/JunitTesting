package com.example.junittesting.controller;

import com.example.junittesting.entity.Employee;
import com.example.junittesting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeServiceInterface;

    @GetMapping("/emp/{empid}")
    public ResponseEntity<?> fetchEmployeeById(@PathVariable("empid") Long empidL){
        try{
            return new ResponseEntity<Employee>(employeeServiceInterface.getEmpById(empidL), HttpStatus.OK);
        }catch (Exception e) {
            ControllerException controllerException = new ControllerException(e.getMessage() + " " + e.getCause());
                    return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
        }
    }
}
