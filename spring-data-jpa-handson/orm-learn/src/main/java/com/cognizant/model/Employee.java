package com.cognizant.model;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;
    @Column(name = "emp_name")
    private String name;
    @Column(name = "emp_salary")
    private double salary;
    @Column(name = "emp_permanent")
    private boolean permanent;
    @Column(name = "emp_date_of_birth")
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "emp_dp_id")
    @ToString.Exclude
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "employee_skill",
            joinColumns = @JoinColumn(name = "es_em_id"),
            inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
    @ToString.Exclude
    private Set<Skill> skillList;
}
