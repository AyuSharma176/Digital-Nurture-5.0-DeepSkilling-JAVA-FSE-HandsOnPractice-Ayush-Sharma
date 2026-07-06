package com.cognizant.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Country {
    @Id
    @Column(name="code")
    private String co_code;

    @Column(name="name")
    private String co_name;

    public String getCo_name() {
        return co_name;
    }

    public void setCo_name(String co_name) {
        this.co_name = co_name;
    }

    public String getCo_code() {
        return co_code;
    }

    public void setCo_code(String co_code) {
        this.co_code = co_code;
    }

    @Override
    public String toString() {
        return "Country{" +
                "co_code='" + co_code + '\'' +
                ", co_name='" + co_name + '\'' +
                '}';
    }


}
