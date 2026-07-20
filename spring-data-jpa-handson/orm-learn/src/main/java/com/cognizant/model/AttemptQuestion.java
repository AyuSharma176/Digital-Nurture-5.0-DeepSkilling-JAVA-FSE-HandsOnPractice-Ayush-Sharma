package com.cognizant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import org.aspectj.weaver.patterns.TypePatternQuestions;

import java.util.Set;

@Entity
@Table(name = "attempt_question")
@Data
public class AttemptQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aq_id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "aq_at_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Attempt attempt;

    @ManyToOne
    @JoinColumn(name = "aq_qu_id")
    private Question question;

    @OneToMany(mappedBy = "attemptQuestion", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AttemptOption> attemptOptionList;
}