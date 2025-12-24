package com.example.agri.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record FarmRequest(
        @NotBlank String name,
        @NotBlank String location,
        @Positive Double totalAreaHectares
) {}
