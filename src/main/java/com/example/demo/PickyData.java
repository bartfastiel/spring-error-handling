package com.example.demo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PickyData(
        @Min(0)
        Integer age,
        @NotBlank
        String name
) {
}
