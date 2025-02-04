package com.estacionamento.app.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("Resource not Found Id " +id);
    }
}
