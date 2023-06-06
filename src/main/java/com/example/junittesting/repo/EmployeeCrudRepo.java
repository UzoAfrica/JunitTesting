package com.example.junittesting.repo;

import com.example.junittesting.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCrudRepo  extends JpaRepository<Employee, Long> {


}
