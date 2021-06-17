package com.example.ss3.repository;

import com.example.ss3.entity.EmployeeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> findAllByName(String name, Pageable pageable);
}
