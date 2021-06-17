package com.example.ss3.controller;

import com.example.ss3.dto.EmployeeDto;
import com.example.ss3.entity.EmployeeEntity;
import com.example.ss3.model.BaseResponse;
import com.example.ss3.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity getAllEmployee(@RequestParam(value = "name", required = false, defaultValue = "a") String name,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                        @RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
        BaseResponse res = new BaseResponse();
        res.data = employeeService.getAllEmployee();
//        name, PageRequest.of(page, limit)
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody EmployeeDto employeeDto) {
        EmployeeEntity entity = new EmployeeEntity();
        entity.setName(employeeDto.getName());
        entity.setSalary(employeeDto.getSalary());
        BaseResponse res = new BaseResponse();
        res.data = employeeService.addEmployee(entity);
        return ResponseEntity.ok(res);
    }

    @RequestMapping("/delete")
    @GetMapping()
    public ResponseEntity deleteProduct(@RequestParam(value = "id", required = true, defaultValue = "") Integer id) {
        BaseResponse res = new BaseResponse();
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok(res);
    }

    @RequestMapping("/update")
    @GetMapping()
    public ResponseEntity updateEmployee(@RequestParam(value = "id", required = true, defaultValue = "") Integer id,
                                        @RequestParam(value = "name", required = false, defaultValue = "") String name,
                                        @RequestParam(value = "salary", required = false, defaultValue = "") Integer salary) {
        BaseResponse res = new BaseResponse();
        employeeService.updateEmployee(id,name,salary);
        return ResponseEntity.ok(res);
    }

}
