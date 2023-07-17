package com.example.demo;

import java.util.List;

public record ApiValidationError(
        String message,
        List<ApiErrorField> fields
) {
}
