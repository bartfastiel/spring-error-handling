package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fails")
public class FailController {

    @PutMapping
    public String fails(@Valid @RequestBody PickyData pickyData) {
        return "bla";
    }
}
