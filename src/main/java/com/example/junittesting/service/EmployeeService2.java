package com.example.junittesting.service;

import com.example.junittesting.entity.Employee;
import com.example.junittesting.repo.EmployeeCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService2 implements EmployeeServiceInterface {

    @Autowired
    private EmployeeCrudRepo crudRepo;

    @Override
    public Employee findById(Long id) {
        return crudRepo.findById(id).get() ;
    }
}
