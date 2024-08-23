package com.oriontek.backend_demo.repository;

import com.oriontek.backend_demo.model.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {

}