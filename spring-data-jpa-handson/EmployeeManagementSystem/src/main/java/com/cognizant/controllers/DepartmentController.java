package com.cognizant.controllers;

import com.cognizant.model.Department;
import com.cognizant.repository.EmployeeRepository;
import com.cognizant.service.DepartmentService;
import com.cognizant.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(EmployeeService employeeService, EmployeeRepository employeeRepository, DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable int id){
        return departmentService.getDepartmentById(id);
    }
    @PostMapping
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable int id,@RequestBody Department department){
        return departmentService.updateDepartment(id,department);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        departmentService.deleteDepartment(id);
    }
}
