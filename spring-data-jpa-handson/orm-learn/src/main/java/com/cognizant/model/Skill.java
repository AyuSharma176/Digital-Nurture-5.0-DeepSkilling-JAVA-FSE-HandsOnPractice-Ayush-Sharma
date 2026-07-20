package com.cognizant.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sk_id")
    private int id;

    @Column(name = "sk_name")
    private String name;

    @ManyToMany(mappedBy = "skillList")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Employee> employeeList;
}
