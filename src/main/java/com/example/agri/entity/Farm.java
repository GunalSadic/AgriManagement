package com.example.agri.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "farms")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    private String location;

    @Positive
    private Double totalAreaHectares;

    protected Farm() {}

    public Farm(String name, String location, Double totalAreaHectares) {
        this.name = name;
        this.location = location;
        this.totalAreaHectares = totalAreaHectares;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Double getTotalAreaHectares() {
        return totalAreaHectares;
    }
}
