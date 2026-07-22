package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.models.*;	
public interface UserRepository extends JpaRepository<Users, Long> {}