package com.example.Spring_MVC.dto;

public class TechLeadDTO {
    private Long id;
    private String name;

    public TechLeadDTO() {
    }

    public TechLeadDTO(Long id, String name) {
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
        return "TechLeadDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
