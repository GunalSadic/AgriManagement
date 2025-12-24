package com.example.agri.service;

import com.example.agri.dto.CropRequest;
import com.example.agri.dto.CropResponse;
import com.example.agri.entity.Crop;
import com.example.agri.entity.Farm;
import com.example.agri.repository.CropRepository;
import com.example.agri.repository.FarmRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CropService {

    private final CropRepository cropRepository;
    private final FarmRepository farmRepository;

    public CropService(CropRepository cropRepository, FarmRepository farmRepository) {
        this.cropRepository = cropRepository;
        this.farmRepository = farmRepository;
    }

    public CropResponse createCrop(CropRequest request) {
        Farm farm = farmRepository.findById(request.getFarmId())
                .orElseThrow(() -> new IllegalArgumentException("Farm not found"));

        Crop crop = new Crop();
        crop.setName(request.getName());
        crop.setType(request.getType());
        crop.setPlantingDate(request.getPlantingDate());
        crop.setExpectedHarvestDate(request.getExpectedHarvestDate());
        crop.setFarm(farm);

        Crop saved = cropRepository.save(crop);
        return mapToResponse(saved);
    }

    public List<CropResponse> getCropsByFarm(Long farmId) {
        return cropRepository.findByFarmId(farmId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private CropResponse mapToResponse(Crop crop) {
        CropResponse response = new CropResponse();
        response.setId(crop.getId());
        response.setName(crop.getName());
        response.setType(crop.getType());
        response.setPlantingDate(crop.getPlantingDate());
        response.setExpectedHarvestDate(crop.getExpectedHarvestDate());
        response.setFarmId(crop.getFarm().getId());
        return response;
    }
}
