package com.cognizant.service;

import com.cognizant.model.Department;
import com.cognizant.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(int id) {
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int id, Department department){
        department.setId(id);
        return departmentRepository.save(department);
    }
    public void deleteDepartment(int id){
        departmentRepository.deleteById(id);
    }

}