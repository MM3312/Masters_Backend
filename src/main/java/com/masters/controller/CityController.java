package com.masters.controller;

import com.masters.dto.CityDTO;
import com.masters.dto.CityGetDTO;
import com.masters.dto.CityUpdateDTO;
import com.masters.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing City-related operations.
 * Provides endpoints for retrieving and saving city data.
 */
@RestController
@RequestMapping("/api/cities")
@CrossOrigin("*")
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * Retrieves a simplified list of all active cities.
     * 
     * @return List of CityGetDTO containing basic city details
     */
    @GetMapping("/GetAllCities")
    public ResponseEntity<List<CityGetDTO>> getAllCitiesSummary() {
        return ResponseEntity.ok(cityService.getAllCitiesSummary());
    }

    /**
     * Saves a new city or updates an existing one based on the provided DTO.
     * 
     * @param cityDTO The data transfer object containing city details
     * @return The saved/updated CityDTO
     */
    @PostMapping("/save")
    public ResponseEntity<CityDTO> saveCity(@RequestBody CityDTO cityDTO) {
        CityDTO savedCity = cityService.saveCity(cityDTO);
        return ResponseEntity.ok(savedCity);
    }

    /**
     * Updates an existing city record based on ID.
     * 
     * @param id        The ID of the city to update
     * @param updateDTO The new data for the city (excluding createdBy)
     * @return The updated CityUpdateDTO response
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<CityUpdateDTO> updateCity(@PathVariable Integer id, @RequestBody CityUpdateDTO updateDTO) {
        CityUpdateDTO updatedCity = cityService.updateCity(id, updateDTO);
        return ResponseEntity.ok(updatedCity);
    }

    /**
     * Deletes a city record based on ID (Soft Delete).
     * 
     * @param id        The ID of the city to delete
     * @param updatedBy The ID of the user performing the deletion
     * @return ResponseEntity with success message
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCity(@PathVariable Integer id, @RequestParam Integer updatedBy) {
        cityService.deleteCity(id, updatedBy);
        return ResponseEntity.ok("City deleted successfully with id: " + id);
    }
}
