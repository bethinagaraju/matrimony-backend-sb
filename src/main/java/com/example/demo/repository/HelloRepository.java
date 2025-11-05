package com.example.demo.repository;

import com.example.demo.entity.HelloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends JpaRepository<HelloEntity, Long> {
    // Custom query methods can be added here if needed
}
