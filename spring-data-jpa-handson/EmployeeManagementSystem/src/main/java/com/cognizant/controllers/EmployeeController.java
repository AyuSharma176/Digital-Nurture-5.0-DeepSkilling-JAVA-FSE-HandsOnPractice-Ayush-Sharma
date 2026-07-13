package com.cognizant.controllers;

import com.cognizant.model.Employee;
import com.cognizant.repository.EmployeeRepository;
import com.cognizant.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;

    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id,employee);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
