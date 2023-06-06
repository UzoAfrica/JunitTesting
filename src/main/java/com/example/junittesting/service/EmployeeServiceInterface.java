package com.example.junittesting.service;

import com.example.junittesting.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeServiceInterface {
    Employee findById(Long id);
}
