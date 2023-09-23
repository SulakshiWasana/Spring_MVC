package com.example.Spring_MVC.repository;

import com.example.Spring_MVC.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {
    Project findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
}
