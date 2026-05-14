package com.masters.controller;

import com.masters.dto.CityDTO;
import com.masters.entity.City;
import com.masters.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/save")
    public ResponseEntity<CityDTO> saveCity(@RequestBody CityDTO cityDTO) {
        CityDTO savedCity = cityService.saveCity(cityDTO);
        return ResponseEntity.ok(savedCity);
    }
}
