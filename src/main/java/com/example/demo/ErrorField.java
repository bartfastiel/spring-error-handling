package com.example.demo;

import lombok.Builder;

@Builder
public record ErrorField(
        String fieldName,
        String errorMessage
) {
}
