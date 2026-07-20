    package com.cognizant.service;

    import com.cognizant.model.Employee;
    import com.cognizant.repository.EmployeeRepository;
    import jakarta.persistence.EntityManager;
    import jakarta.persistence.TypedQuery;
    import jakarta.persistence.criteria.CriteriaBuilder;
    import jakarta.persistence.criteria.CriteriaQuery;
    import jakarta.persistence.criteria.Predicate;
    import jakarta.persistence.criteria.Root;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import org.springframework.transaction.annotation.Transactional;

    import java.util.ArrayList;
    import java.util.List;


    @Service
    public class EmployeeService {
        private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(EmployeeService.class);

        @Autowired
        private EmployeeRepository employeeRepository;
        @Autowired
        private EntityManager entityManager;

        @Transactional
        public List<Employee> getAllEmployeesBySalaryRange(double minSalary, double maxSalary) {
            LOGGER.info("start");

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
            Root<Employee> root = cq.from(Employee.class);

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(cb.greaterThanOrEqualTo(root.get("salary"), minSalary));
            predicates.add(cb.lessThanOrEqualTo(root.get("salary"), maxSalary));

            cq.where(predicates.toArray(new Predicate[0]));

            TypedQuery<Employee> query = entityManager.createQuery(cq);
            return query.getResultList();
        }
        @Transactional
        public Employee get(int id){
            LOGGER.info("start");
            return employeeRepository.findById(id).get();
        }

        @Transactional
        public void save(Employee employee){
            LOGGER.info("start");
            employeeRepository.save(employee);
            LOGGER.info("end");
        }
        @Transactional
        public List<Employee> getAllPermanentEmployees() {
            LOGGER.info("start");
            return employeeRepository.getAllPermanentEmployees();
        }
        @Transactional
        public double getAverageSalary(int id) {
            LOGGER.info("start");
            return employeeRepository.getAverageSalary(id);
        }
        @Transactional
        public List<Employee> getAllEmployeesNative() {
            LOGGER.info("start");
            return employeeRepository.getAllEmployeesNative();
        }
    }
