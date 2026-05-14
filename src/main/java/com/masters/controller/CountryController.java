package com.masters.controller;

import com.masters.entity.Country;
import com.masters.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@CrossOrigin("*")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/active")
    public ResponseEntity<?> getActiveCountries() {
        try {
            return ResponseEntity.ok(countryService.getActiveCountries());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveCountry(@RequestBody Country country) {
        try {
            Country savedCountry = countryService.saveCountry(country);
            return ResponseEntity.ok(savedCountry);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCountry(@PathVariable Integer id, @RequestBody Country country) {
        try {
            Country updatedCountry = countryService.updateCountry(id, country);
            return ResponseEntity.ok(updatedCountry);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Integer id, @RequestParam Integer updatedBy) {
        try {
            countryService.deleteCountry(id, updatedBy);
            return ResponseEntity.ok("Country deleted successfully (Status set to 0)");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
        }
    }
}
