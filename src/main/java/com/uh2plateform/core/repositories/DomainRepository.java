package com.uh2plateform.core.repositories;

import com.uh2plateform.core.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DomainRepository extends JpaRepository<Domain, UUID> {

    List<Domain> findByNameContainingIgnoreCase(String substring);

}
