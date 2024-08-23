package com.oriontek.backend_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oriontek.backend_demo.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
}
