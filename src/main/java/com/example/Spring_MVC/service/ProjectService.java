package com.example.Spring_MVC.service;

import com.example.Spring_MVC.dto.ProjectDTO;
import com.example.Spring_MVC.entity.Project;
import com.example.Spring_MVC.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository; // Inject the ProjectRepository

    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream()
                .map(project -> new ProjectDTO(project.getId(), project.getName()))
                .collect(Collectors.toList());
    }

    public Optional<ProjectDTO> getProjectById(Long id) {
        Project project = projectRepository.findById(id);
        return project != null ? Optional.of(new ProjectDTO(project.getId(), project.getName())) : Optional.empty();
    }

    public ProjectDTO createProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setName(projectDTO.getName());
        // Set other attributes as needed
        Project createdProject = projectRepository.save(project);
        return new ProjectDTO(createdProject.getId(), createdProject.getName());
    }

    public Optional<ProjectDTO> updateProject(Long id, ProjectDTO updatedProjectDTO) {
        Project existingProject = projectRepository.findById(id);
        if (existingProject != null) {
            existingProject.setName(updatedProjectDTO.getName());
            // Update other attributes as needed
            Project updatedProject = projectRepository.save(existingProject);
            return Optional.of(new ProjectDTO(updatedProject.getId(), updatedProject.getName()));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
