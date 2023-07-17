package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;


@RestControllerAdvice
public class Handler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<ErrorField> handle(BindException e) {
        List<ErrorField> errorFields = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            errorFields.add(new ErrorField(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            ));
        }
        return errorFields;
    }
}
