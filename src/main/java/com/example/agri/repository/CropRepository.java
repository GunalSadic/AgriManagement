package com.example.agri.repository;

import com.example.agri.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    List<Crop> findByFarmId(Long farmId);
}
