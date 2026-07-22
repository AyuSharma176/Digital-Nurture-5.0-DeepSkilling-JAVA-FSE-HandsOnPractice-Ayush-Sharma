package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.cognizant.models.*;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}