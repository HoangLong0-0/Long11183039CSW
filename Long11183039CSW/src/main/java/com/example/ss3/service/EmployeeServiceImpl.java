package com.example.ss3.service;

import com.example.ss3.entity.EmployeeEntity;
import com.example.ss3.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public EmployeeEntity addEmployee(EmployeeEntity p) {
        return employeeRepo.save(p);
    }

    @Override
    public EmployeeEntity deleteEmployee(Integer productid) {
        EmployeeEntity temp = new EmployeeEntity();
        EmployeeEntity p = employeeRepo.findById(productid).get();
        temp = p;
        employeeRepo.delete(p);
        return temp;
    }

    @Override
    public void updateEmployee(Integer id, String name, Integer salary) {
        EmployeeEntity p = employeeRepo.findById(id).get();
        if(!StringUtils.isEmpty(name))
        {
            p.setName(name);
        }
        if(salary!=null)
        {
            p.setSalary(salary);
        }
        employeeRepo.save(p);
    }

    @Override
    public List<EmployeeEntity> getAllEmployee(String name, Pageable pageable) {
        return employeeRepo.findAllByName(name, pageable);
    }

}
