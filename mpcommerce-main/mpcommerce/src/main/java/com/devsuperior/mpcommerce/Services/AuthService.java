package com.devsuperior.mpcommerce.Services;

import com.devsuperior.mpcommerce.Services.exceptions.ForbiddenException;
import com.devsuperior.mpcommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserService service;

    public void validateSelfOrAdmin(long userID){
        User me = service.authenticated();
        if(!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userID)){
            throw new ForbiddenException("Access denied");

        }


    }
}
