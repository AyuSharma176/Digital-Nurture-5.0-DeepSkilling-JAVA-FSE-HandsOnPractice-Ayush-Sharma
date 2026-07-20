package com.cognizant.service;

import com.cognizant.model.Employee;
import com.cognizant.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id){
        return employeeRepository.findById(id);
    }
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee employee){
        employee.setId(id);
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(int id){
        employeeRepository.deleteById(id);
    }
}
