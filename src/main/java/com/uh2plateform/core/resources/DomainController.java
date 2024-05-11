package com.uh2plateform.core.resources;

import com.uh2plateform.core.model.Domain;
import com.uh2plateform.core.repositories.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/domains")
public class DomainController {

    @Autowired
    DomainRepository domainRepository;

    // Create
    @PostMapping
    public ResponseEntity<Domain> createAdfDomain(@RequestBody Domain adfDomain) {
        return new ResponseEntity<>(domainRepository.save(adfDomain), HttpStatus.CREATED);
    }

    // Read all
    @GetMapping
    public List<Domain> getAllAdfDomains() {
        return domainRepository.findAll();
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<Domain> getAdfDomainById(@PathVariable String id) {
        Optional<Domain> adfDomain = domainRepository.findById(UUID.fromString(id));
        return adfDomain.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Domain> updateAdfDomain(@PathVariable String id, @RequestBody Domain adfDomainDetails) {
        Optional<Domain> adfDomainOptional = domainRepository.findById(UUID.fromString(id));

        if (!adfDomainOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Domain adfDomain = adfDomainOptional.get();
        adfDomain.setName(adfDomainDetails.getName());
        adfDomain.setKey(adfDomainDetails.getKey());
        adfDomain.setType(adfDomainDetails.getType());

        Domain updatedAdfDomain = domainRepository.save(adfDomain);
        return ResponseEntity.ok(updatedAdfDomain);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdfDomain(@PathVariable String id) {

        if (!domainRepository.existsById(UUID.fromString(id))) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        domainRepository.deleteById(UUID.fromString(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{subs}")
    @ResponseBody
    public List<Domain> findByNameContaining(@PathVariable String subs) {
        return domainRepository.findByNameContainingIgnoreCase(subs);
    }

    @GetMapping("/dummy")
    @ResponseBody
    public String generateDummy() {

        domainRepository.save(Domain.builder().name("Finance").build());
        domainRepository.save(Domain.builder().name("HR").build());

        return "OK";

    }

}