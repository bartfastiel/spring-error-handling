package com.example.demo;

import lombok.Builder;

@Builder
public record ApiErrorField(
        String fieldName,
        String errorMessage
) {
}
