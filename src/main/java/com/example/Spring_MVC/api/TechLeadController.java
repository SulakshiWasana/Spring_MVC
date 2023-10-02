package com.example.Spring_MVC.api;

import com.example.Spring_MVC.dto.ProjectDTO;
import com.example.Spring_MVC.dto.TechLeadDTO;
import com.example.Spring_MVC.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/techLeads")
public class TechLeadController {

    @Autowired
    private TechLeadService techLeadService;

    @GetMapping
    public List<TechLeadDTO> getAllTechLeads() {
        return techLeadService.getAllTechLeads();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechLeadDTO> getTechLeadById(@PathVariable Long id) {
        Optional<TechLeadDTO> project = techLeadService.getTechLeadById(id);
        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<TechLeadDTO> createTechLead(@RequestBody TechLeadDTO techLeadDTO) {
        TechLeadDTO createTechLead = techLeadService.createTechLead(techLeadDTO);
        return ResponseEntity.ok(createTechLead);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechLeadDTO> updateTechLead(@PathVariable Long id, @RequestBody TechLeadDTO updatedTechLeadDTO) {
        Optional<TechLeadDTO> techLeadDTO = techLeadService.updateTechLead(id, updatedTechLeadDTO);
        if (techLeadDTO.isPresent()) {
            return ResponseEntity.ok(techLeadDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechLead(@PathVariable Long id) {
        if (techLeadService.deleteTechLead(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
