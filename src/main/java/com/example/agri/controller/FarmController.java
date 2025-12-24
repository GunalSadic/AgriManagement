package com.example.agri.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.agri.dto.FarmRequest;
import com.example.agri.dto.FarmResponse;
import com.example.agri.service.FarmService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/farms")
@Tag(name = "Farm Management")
public class FarmController {

    private final FarmService service;

    public FarmController(FarmService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new farm")
    @PostMapping
    public ResponseEntity<FarmResponse> create(
            @Valid @RequestBody FarmRequest request
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.create(request));
    }

    @Operation(summary = "Get all farms")
    @GetMapping
    public ResponseEntity<List<FarmResponse>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Get farm by ID")
    @GetMapping("/{id}")
    public ResponseEntity<FarmResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}
