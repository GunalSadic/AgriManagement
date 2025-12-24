package com.example.agri.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CropRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotNull
    private LocalDate plantingDate;

    private LocalDate expectedHarvestDate;

    @NotNull
    private Long farmId;

    // getters and setters
}
