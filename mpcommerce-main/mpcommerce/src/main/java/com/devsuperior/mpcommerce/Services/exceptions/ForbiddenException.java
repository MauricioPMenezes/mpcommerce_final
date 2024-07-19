package com.devsuperior.mpcommerce.Services.exceptions;


public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String msg){
        super(msg);
    }
}

