package com.cognizant.repository;

import com.cognizant.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    List<Country> findByNameContainingIgnoreCase(String name);
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    List<Country> findByNameStartingWithIgnoreCase(String letter);
}