package com.cognizant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private String code;

    @Column(name="date")
    private LocalDate date;

    @Column(name="open")
    private double open;

    @Column(name="close")
    private double close;

    @Column(name="volume")
    private long volume;

}
