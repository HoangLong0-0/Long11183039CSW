package com.example.ss3.service;

import com.example.ss3.entity.EmployeeEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getAllEmployee();
    EmployeeEntity addEmployee(EmployeeEntity p);
    EmployeeEntity deleteEmployee(Integer employeeid);
    void updateEmployee(Integer id, String name, Integer salary);
    List<EmployeeEntity> getAllEmployee(String name, Pageable pageable);
}
