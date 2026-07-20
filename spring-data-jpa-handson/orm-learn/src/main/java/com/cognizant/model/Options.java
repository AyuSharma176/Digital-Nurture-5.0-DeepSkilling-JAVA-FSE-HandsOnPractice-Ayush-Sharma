package com.cognizant.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "options")
@Data
public class Options {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "op_id")
    private int id;

    @Column(name = "op_text")
    private String text;

    @Column(name = "op_correct")
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "op_qu_id")
    @ToString.Exclude
    private Question question;
}