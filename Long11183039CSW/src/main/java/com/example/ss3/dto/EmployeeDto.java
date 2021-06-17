package com.example.ss3.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class EmployeeDto {
    private Integer id;
    private String name;
    private Integer salary;
    private boolean isCheck;
}
