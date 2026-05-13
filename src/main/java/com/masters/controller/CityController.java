package com.masters.controller;

import com.masters.entity.City;
import com.masters.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin("*")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * Endpoint to save or update a city.
     * 
     * @param city The city details from request body
     * @return ResponseEntity containing the saved city
     */
    @PostMapping("/save")
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        City savedCity = cityService.saveCity(city);
        return ResponseEntity.ok(savedCity);
    }
}
