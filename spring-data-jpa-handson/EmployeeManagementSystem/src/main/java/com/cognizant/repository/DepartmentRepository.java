package com.cognizant.repository;

import com.cognizant.model.Department;
import com.cognizant.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
