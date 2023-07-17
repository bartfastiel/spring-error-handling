package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class Handler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handle(BindException e) {
        Map<String, String> message = new HashMap<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            message.put(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        }
        return message;
    }
}
