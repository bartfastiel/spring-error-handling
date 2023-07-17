package com.example.demo;

import lombok.Builder;
import lombok.Singular;

import java.util.Map;

@Builder
public record ErrorMessage(
        String message,
        @Singular("fieldError")
        Map<String, String> fieldErrors
) {
}
