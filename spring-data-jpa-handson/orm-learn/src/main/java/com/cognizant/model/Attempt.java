package com.cognizant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "attempt")
@Data
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "at_id")
    private int id;

    @Column(name = "at_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "at_us_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    @OneToMany(mappedBy = "attempt", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AttemptQuestion> attemptQuestionList;
}