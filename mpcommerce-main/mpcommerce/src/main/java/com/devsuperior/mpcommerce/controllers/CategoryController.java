package com.devsuperior.mpcommerce.controllers;

import com.devsuperior.mpcommerce.Services.CategoryService;
import com.devsuperior.mpcommerce.Services.exceptions.ResourceNotFoundException;
import com.devsuperior.mpcommerce.dto.CategoryDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<CategoryDTO>> findAllCategories(Pageable pageable) {
        try {
            Page<CategoryDTO> dto = categoryService.findAllCategories(pageable);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado!");
        }
    }
}
