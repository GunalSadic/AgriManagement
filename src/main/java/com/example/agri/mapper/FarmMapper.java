package com.example.agri.mapper;

import org.springframework.stereotype.Component;

import com.example.agri.dto.FarmRequest;
import com.example.agri.dto.FarmResponse;
import com.example.agri.entity.Farm;

@Component
public class FarmMapper {

    public Farm toEntity(FarmRequest request) {
        return new Farm(
                request.name(),
                request.location(),
                request.totalAreaHectares()
        );
    }

    public FarmResponse toResponse(Farm farm) {
        return new FarmResponse(
                farm.getId(),
                farm.getName(),
                farm.getLocation(),
                farm.getTotalAreaHectares()
        );
    }
}
