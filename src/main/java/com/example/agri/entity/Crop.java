package com.example.agri.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String type;

    @NotNull
    @Column(nullable = false)
    private LocalDate plantingDate;

    private LocalDate expectedHarvestDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "farm_id")
    private Farm farm;

    public Crop() {}

    // getters and setters
}
