package com.example.Spring_MVC.service;

import com.example.Spring_MVC.dto.TechLeadDTO;
import com.example.Spring_MVC.entity.TechLead;
import com.example.Spring_MVC.repository.TechLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TechLeadService {
    @Autowired
    private TechLeadRepository techLeadRepository;

    public List<TechLeadDTO> getAllTechLeads() {
        List<TechLead> techLeads = techLeadRepository.findAll();
        return techLeads.stream()
                .map(techLead -> new TechLeadDTO(techLead.getId(), techLead.getName()))
                .collect(Collectors.toList());
    }

    public Optional<TechLeadDTO> getTechLeadById(Long id) {
        TechLead techLead = techLeadRepository.findById(id);
        return techLead != null ? Optional.of(new TechLeadDTO(techLead.getId(), techLead.getName())) : Optional.empty();
    }

    public TechLeadDTO createTechLead(TechLeadDTO techLeadDTO) {
        TechLead techLead = new TechLead();
        techLead.setName(techLeadDTO.getName());
        TechLead createdTechLead = techLeadRepository.save(techLead);
        return new TechLeadDTO(createdTechLead.getId(), createdTechLead.getName());
    }

    public Optional<TechLeadDTO> updateTechLead(Long id, TechLeadDTO updatedTechLeadDTO) {
        TechLead existingTechLead = techLeadRepository.findById(id);
        if (existingTechLead != null) {
            existingTechLead.setName(updatedTechLeadDTO.getName());
            TechLead updatedTechLead = techLeadRepository.save(existingTechLead);
            return Optional.of(new TechLeadDTO(updatedTechLead.getId(), updatedTechLead.getName()));
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteTechLead(Long id) {
        if (techLeadRepository.existsById(id)) {
            techLeadRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
