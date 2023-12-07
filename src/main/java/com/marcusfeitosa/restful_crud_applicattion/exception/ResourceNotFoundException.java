package com.marcusfeitosa.restful_crud_applicattion.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private Long fieldValue;

    public ResourceNotFoundException(String resourceName, String fieldName, Long fielValue){
        super(String.format("%s nao encontrado com %s : %s", resourceName, fieldName, fielValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fielValue;
    }



}


