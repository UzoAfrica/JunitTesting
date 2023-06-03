package com.example.junittesting.service;

import com.example.junittesting.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.PermissionDeniedDataAccessException;

import java.security.Permission;
import java.util.NoSuchElementException;

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeCrudRepo crudRepo;
    @Override
    public Employee getEmpById(Long empidL) {
        try {
            Employee e = crudRepo.findById(empidL).get();
            if (e.getName().equalsIgnoreCase("code")){
                BusinessException be = new BusinessException("403", "Not allowed to access this employer ");
                be.initCause(new PermissionDeniedDataAccessException("dont access employee with this name", null));
                throw be;
            }
            return e;
        }catch (NoSuchElementException e) {
            e.initCause(new DAOLayerException());
            throw e;
        }
    }
}
