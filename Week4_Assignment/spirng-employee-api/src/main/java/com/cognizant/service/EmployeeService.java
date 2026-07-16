package com.cognizant.service;

import com.cognizant.model.Employee;
import com.cognizant.model.EmployeeList;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private List<Employee> loadEmployees() throws Exception {
        JAXBContext context = JAXBContext.newInstance(EmployeeList.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream is = new ClassPathResource("employees.xml").getInputStream();
        EmployeeList employeeList = (EmployeeList) unmarshaller.unmarshal(is);
        return employeeList.getEmployees();
    }

    public List<Employee> getAllEmployees() throws Exception {
        return loadEmployees();
    }

    public Optional<Employee> getEmployeeById(int id) throws Exception {
        return loadEmployees().stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }
}