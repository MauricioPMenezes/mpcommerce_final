package com.devsuperior.mpcommerce.controllers;

import com.devsuperior.mpcommerce.Services.UserService;
import com.devsuperior.mpcommerce.Services.exceptions.ResourceNotFoundException;
import com.devsuperior.mpcommerce.dto.ProductDTO;
import com.devsuperior.mpcommerce.dto.UserDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService  service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value ="/me" )
    public ResponseEntity<UserDTO> findUserMe() {
        UserDTO dto = service.getMe();
        return ResponseEntity.ok(dto);
    }

}
