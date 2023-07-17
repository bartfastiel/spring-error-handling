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
    public ApiValidationError handle(BindException e) {
        List<ApiErrorField> apiErrorFields = new ArrayList<>();
        for (FieldError fieldError : e.getFieldErrors()) {
            apiErrorFields.add(new ApiErrorField(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            ));
        }
        return new ApiValidationError(
                "Validation failed",
                apiErrorFields
        );
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    public ApiError handle(IllegalStateException e) {
        return new ApiError(
                "Precondition failed"
        );
    }
}
