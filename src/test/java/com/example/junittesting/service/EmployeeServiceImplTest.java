package com.example.junittesting.service;

import com.example.junittesting.entity.Employee;
import com.example.junittesting.repo.EmployeeCrudRepo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    @Mock
    EmployeeCrudRepo repo;

    @Test
    public void getEmpByIdTest(1L){
        when(repo.findById(1L)).thenReturn(null);

        Employee testedEmp= employeeServiceImpl.getEmpById(1L);
        assertEquals(testedEmp.getName(), "");
    }

    private Optional<Employee> createEmployeeStub(){
        Employee stubEmp = Employee.builder().id(1L).name("decode").build();
        return Optional.of(stubEmp);
    }
}
