package com.engineering.inventory.repository;

import com.engineering.inventory.domain.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PartRepository extends JpaRepository<Part, Long> {

    Optional<Part> findByCode(String code);
}
