package com.devsuperior.mpcommerce.controllers;

import com.devsuperior.mpcommerce.Services.CategoryService;
import com.devsuperior.mpcommerce.Services.ProductService;
import com.devsuperior.mpcommerce.Services.exceptions.ResourceNotFoundException;
import com.devsuperior.mpcommerce.dto.CategoryDTO;
import com.devsuperior.mpcommerce.dto.ProductDTO;
import com.devsuperior.mpcommerce.dto.ProductMinDTO;
import com.devsuperior.mpcommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;
    ProductRepository repository;


    @GetMapping
    public ResponseEntity<Page<ProductMinDTO>> findAll(@RequestParam(name = "name", defaultValue = "") String name, Pageable pageable) {
        try {
            Page<ProductMinDTO> dto = service.findAll(name,pageable);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }



    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
        try {
            ProductDTO dto = service.findById(id);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);

    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id,@Valid @RequestBody ProductDTO dto) {
        try {
            dto = service.update(id, dto);
            return ResponseEntity.ok(dto);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }


    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> delete( @PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.noContent().build();

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }
}
