package com.example.demo;

import java.util.List;

public record ApiErrorWithFields(
        String message,
        List<ApiErrorField> fields
) {
}
