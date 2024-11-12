package com.example.roxiler.controllers;

import com.example.roxiler.services.DatabaseInitializationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/database")
public class InitializationController {
    private final DatabaseInitializationService initService;

    public InitializationController(DatabaseInitializationService initService) {
        this.initService = initService;
    }

    @GetMapping("/init")
    public void initializeDatabase() {
        initService.initializeDatabase();
    }
}
