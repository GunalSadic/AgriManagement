package com.example.agri.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.agri.dto.FarmResponse;
import com.example.agri.service.FarmService;

@WebMvcTest(FarmController.class)
class FarmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FarmService service;

    @Test
    void createFarm_returns201() throws Exception {
        FarmResponse response =
                new FarmResponse(1L, "Farm A", "RO", 100.0);

        when(service.create(any())).thenReturn(response);

        mockMvc.perform(post("/api/farms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                        {
                          "name": "Farm A",
                          "location": "RO",
                          "totalAreaHectares": 100
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Farm A"));
    }
}
