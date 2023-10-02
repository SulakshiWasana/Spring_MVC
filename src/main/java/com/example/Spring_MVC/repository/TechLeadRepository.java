package com.example.Spring_MVC.repository;

import com.example.Spring_MVC.entity.Project;
import com.example.Spring_MVC.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechLeadRepository extends JpaRepository<TechLead, String> {
    TechLead findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
}
