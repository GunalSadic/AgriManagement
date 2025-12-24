package com.example.agri.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.agri.dto.FarmRequest;
import com.example.agri.dto.FarmResponse;
import com.example.agri.entity.Farm;
import com.example.agri.exception.ResourceNotFoundException;
import com.example.agri.mapper.FarmMapper;
import com.example.agri.repository.FarmRepository;

@Service
@Transactional
public class FarmService {

    private final FarmRepository repository;
    private final FarmMapper mapper;

    public FarmService(FarmRepository repository, FarmMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public FarmResponse create(FarmRequest request) {
        Farm farm = mapper.toEntity(request);
        return mapper.toResponse(repository.save(farm));
    }

    public List<FarmResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    public FarmResponse findById(Long id) {
        Farm farm = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Farm not found with id " + id));
        return mapper.toResponse(farm);
    }
}
