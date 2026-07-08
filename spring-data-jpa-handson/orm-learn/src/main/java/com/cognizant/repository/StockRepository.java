package com.cognizant.repository;

import com.cognizant.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock,String> {
    List<Stock> findByCodeAndDateBetween(String code, LocalDate start, LocalDate end);
    List<Stock> findByCodeAndCloseGreaterThan(String code, double price);
    List<Stock> findTop3ByOrderByVolumeDesc();
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
