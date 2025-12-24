package com.example.agri.dto;

public record FarmResponse(
        Long id,
        String name,
        String location,
        Double totalAreaHectares
) {}
