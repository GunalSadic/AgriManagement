package com.example.agri.farm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.example.agri.service.FarmService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.agri.dto.FarmRequest;
import com.example.agri.dto.FarmResponse;
import com.example.agri.entity.Farm;
import com.example.agri.mapper.FarmMapper;
import com.example.agri.repository.FarmRepository;

@ExtendWith(MockitoExtension.class)
class FarmServiceTest {

    @Mock
    FarmRepository repository;

    @Mock
    FarmMapper mapper;

    @InjectMocks
    FarmService service;

    @Test
    void createFarm_success() {
        FarmRequest request = new FarmRequest("Farm A", "Romania", 120.0);
        Farm farm = new Farm("Farm A", "Romania", 120.0);

        when(mapper.toEntity(request)).thenReturn(farm);
        when(repository.save(farm)).thenReturn(farm);
        when(mapper.toResponse(farm))
                .thenReturn(new FarmResponse(1L, "Farm A", "Romania", 120.0));

        FarmResponse response = service.create(request);

        assertEquals("Farm A", response.name());
    }
}
