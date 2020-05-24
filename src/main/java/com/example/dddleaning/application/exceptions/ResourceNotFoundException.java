package com.example.dddleaning.application.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class ResourceNotFoundException extends RuntimeException {
    private  String ressourceName;
    private String fieldName;
    private  Object fieldValue;

    public ResourceNotFoundException(String message, String ressourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'",ressourceName,fieldName,fieldValue));
        this.ressourceName = ressourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
