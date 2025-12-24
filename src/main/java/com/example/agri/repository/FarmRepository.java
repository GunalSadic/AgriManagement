package com.example.agri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.agri.entity.Farm;

public interface FarmRepository extends JpaRepository<Farm, Long> {
}
