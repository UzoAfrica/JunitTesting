package com.example.junittesting.controller;

import com.example.junittesting.entity.Employee;
import com.example.junittesting.exceptions.ControllerException;
import com.example.junittesting.service.EmployeeService;
import com.example.junittesting.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/code")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

//    @PostMapping("/save")
//    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
//        try{
//            Employee employeeSaved = employeeServiceInterface.addEmployee(employee);
//            return new ResponseEntity<Employee>(employeeSaved,HttpStatus.CREATED);
//        }
//    }

    @GetMapping("/emp/{empid}")
    public ResponseEntity<?> fetchEmployeeDetails(@PathVariable("empId") Long id){
        try{
            return new ResponseEntity<Employee>(employeeServiceInterface.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            ControllerException controllerException = new ControllerException(e.getMessage() + "Exception occured while fetching data " + e.getCause());
                    return new ResponseEntity<ControllerException>(controllerException, HttpStatus.BAD_REQUEST);
        }
    }
}
