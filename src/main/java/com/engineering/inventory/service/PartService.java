package com.engineering.inventory.service;

import com.engineering.inventory.domain.Part;
import com.engineering.inventory.repository.PartRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PartService {
    private final PartRepository partRepository;

    //Dependencies injection via constructor
    public PartService(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Transactional
    public List<Part> findAll() {
        return partRepository.findAll();
    }

    @Transactional
    public Optional<Part> findById(Long id) {
        return partRepository.findById(id);
    }

    @Transactional
    public Optional<Part> findByCode(String code) {
        return partRepository.findByCode(code);
    }

    @Transactional
    public Part save(Part part) {
        // Check for duplicate part
        Optional<Part> existingPart = partRepository.findByCode(part.getCode());
        if (existingPart.isPresent()) {
            throw new RuntimeException("A part with code " + part.getCode() + " already exists.");
        }
        return partRepository.save(part);
    }

    @Transactional
    public Part update(Part part) {
        // Check if the part exists
        Optional<Part> existingPart = partRepository.findById(part.getId());
        if (existingPart.isEmpty()) {
            throw new RuntimeException("Part with id " + part.getId() + " not found.");
        }
        return partRepository.save(part);
    }

    @Transactional
    public void deleteById(Long id) {
    if(!partRepository.existsById(id)) {
        throw new RuntimeException("Part with id " + id + " not found.");
    }
    partRepository.deleteById(id);
    }
}
