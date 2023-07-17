package com.example.demo;

import java.util.List;

public record ApiError(
        String message,
        List<ApiErrorField> fields
) {
}
