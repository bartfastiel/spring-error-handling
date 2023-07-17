package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class Handler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessage handle(BindException e) {
        ErrorMessage.ErrorMessageBuilder message = ErrorMessage.builder().message(e.getMessage());
        for (FieldError fieldError : e.getFieldErrors()) {
            message.fieldError(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        }
        return message.build();
    }
}
