package com.example.Spring_MVC.dto;

public class ProjectDTO {
    private Long id;
    private String name;

    public ProjectDTO() {
    }

    public ProjectDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
